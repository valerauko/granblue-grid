(ns grid-show.models.deck
  (:require [grid-show.models.job :as job]
            [grid-show.models.nakama :as nakama]
            [grid-show.models.summon :as summon]
            [grid-show.models.weapon :refer [deck-list->Weapon]]))

(defrecord Deck [id job team weapons summons])

(defn parse-list
  [{group "group_priority" deck-order "priority"
    weapon-data "weapon" :as data}]
  (let [id (str group deck-order)
        job (job/parse-list data)
        team (nakama/parse-list data)
        weapons (update-vals weapon-data deck-list->Weapon)
        summons (summon/parse-list data)]
    (->Deck id job team weapons summons)))
