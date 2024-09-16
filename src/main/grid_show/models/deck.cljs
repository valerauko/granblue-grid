(ns grid-show.models.deck
  (:require [grid-show.models.job :as job]
            [grid-show.models.nakama :as nakama]
            [grid-show.models.summon :as summon]
            [grid-show.models.weapon :refer [deck-detail->Weapon deck-list->Weapon]]))

;; BasicDeck is based on the minimal information gathered
;; from the deck_list when starting a quest. Stuff like weapon
;; skills, character levels or job details are not included.
(defrecord BasicDeck [id job team weapons summons])
;; DetailedDeck is acquired from the deck endpoint when looking
;; at the team detail page. This has everything about the weapons.
(defrecord DetailedDeck [id job team weapons summons])

(defn parse-list
  [{group "group_priority" deck-order "priority"
    weapon-data "weapon" :as data}]
  (let [id (str group deck-order)
        job (job/parse-list data)
        team (nakama/parse-list data)
        weapons (update-vals weapon-data deck-list->Weapon)
        summons (summon/parse-list data)]
    (->BasicDeck id job team weapons summons)))

(defn parse-detail
  [{{int-id "priority"
     {:strs [weapons]} "pc"} "deck" :as data}]
  (let [id (str int-id)
        job (job/parse-detail data)
        team (nakama/parse-detail data)
        weapons (update-vals weapons deck-detail->Weapon)
        summons (summon/parse-detail data)]
    (->DetailedDeck id job team weapons summons)))

(defn upsert
  [new old]
  ()
  (cond
    (instance? BasicDeck old) new
    (instance? DetailedDeck new) new
    (empty? old) new
    :else old))
