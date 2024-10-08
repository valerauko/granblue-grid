(ns grid-show.state
  (:require [cognitect.transit :as t]
            [grid-show.collections :refer [index-by]]
            [grid-show.models.deck :as deck]
            [grid-show.models.summon :refer [support->Summon]]
            [re-frame.core :as rf]))

(rf/reg-event-db
 ::update-deck-info
 (fn [{old-decks ::decks :as db} [_ body]]
   (let [decoder (t/reader :json)
         {:strs [supporter] :as data} (t/read decoder body)
         decks (some->> (get data "deck_list")
                        vals
                        (map deck/parse-list)
                        (index-by :id))]
     (js/console.debug "Supporter:" (clj->js supporter))
     (js/console.debug "Decks:" (clj->js decks))
     (assoc db
            ::supporter (support->Summon supporter)
            ::decks (merge-with deck/upsert {} old-decks decks)))))

(rf/reg-event-db
 ::update-deck-detail
 (fn [db [_ body]]
   (let [decoder (t/reader :json)
         data (t/read decoder body)
         deck (deck/parse-detail data)]
     (js/console.debug "Detailed deck:" (clj->js deck))
     (-> db
         (update-in [::decks (:id deck)] deck/upsert deck)
         (assoc ::active (:id deck))))))

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
 :-> :job)

(rf/reg-sub
 ::team
 :<- [::active-deck]
 :-> :team)

(rf/reg-sub
 ::supporter
 :-> ::supporter)

(rf/reg-sub
 ::summons
 :<- [::active-deck]
 :-> :summons)

(rf/reg-sub
 ::weapons
 :<- [::active-deck]
 :-> :weapons)
