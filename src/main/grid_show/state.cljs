(ns grid-show.state
  (:require [cognitect.transit :as t]
            [grid-show.collections :refer [index-by]]
            [re-frame.core :as rf]))

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
            ::supporter supporter
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
