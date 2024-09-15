(ns grid-show.state
  (:require [cognitect.transit :as t]
            [grid-show.collections :refer [index-by]]
            [re-frame.core :as rf]))

(defrecord Summon [id image level plus])

(defn support->Summon
  [{id "summon_id"
    image "summon_image_id"
    level "summon_level"
    plus "summon_quality"}]
  (->Summon id image level plus))

(rf/reg-event-db
 ::update-deck-info
 (fn [{old-decks ::decks :as db} [_ body]]
   (let [decoder (t/reader :json)
         {:strs [supporter] :as data} (t/read decoder body)
         decks (some-> data
                       (get "deck_list")
                       vals
                       (index-by (fn [{group "group_priority" deck "priority"}]
                                   (str group deck))))]
     (js/console.debug "Supporter:" (clj->js supporter))
     (js/console.debug "Decks:" (clj->js decks))
     (assoc db
            ::supporter (support->Summon supporter)
            ::decks (merge {} old-decks decks)))))

(defn parse-deck-id
  [request-data id-key]
  (let [decoder (t/reader :json)]
    (-> (t/read decoder request-data) (get id-key) str)))

(rf/reg-event-db
 ::start-quest
 (fn [db [_ request-data]]
   (let [deck (parse-deck-id request-data "deck_id")]
     (assoc db ::active deck))))

(rf/reg-event-db
 ::join-raid
 (fn [db [_ request-data]]
   (let [deck (parse-deck-id request-data "user_deck_priority")]
     (assoc db ::active deck))))

(rf/reg-event-db
 ::force-deck
 (fn [db [_ deck]]
   (assoc db ::active deck)))

(rf/reg-sub
 ::active-deck
 (fn [{::keys [active decks]} _]
   (get decks active)))

(rf/reg-sub
 ::active-deck?
 :<- [::active-deck]
 :-> some?)

(rf/reg-sub
 ::job
 :<- [::active-deck]
 (fn [{{id "master_id" image "job_id"} "job" skills "setaction"}]
   {:id id
    :image image
    :skills (into [] (comp (map #(get % "name"))
                           (filter some?)) skills)}))

(rf/reg-sub
 ::team
 :<- [::active-deck]
 (fn [{team "npc"}]
   (mapv
    (fn [{id "base_npc_id" image "npc_id" pluses "quality"}]
      {:id id
       :image image
       :pluses (js/parseInt pluses)})
    (vals team))))

(rf/reg-sub
 ::supporter
 :-> ::supporter)

(rf/reg-sub
 ::summons
 :<- [::active-deck]
 (fn [{{{main "image_id"} "1" :as summons} "summon" subs "sub_summon"}]
   {:main main
    :summons (mapv
              (fn [i]
                (get-in summons [(str i) "image_id"]))
              (range 2 6))
    :subs (mapv #(get-in subs [(str %) "image_id"]) [1 2])}))
