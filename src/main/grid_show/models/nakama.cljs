(ns grid-show.models.nakama)

(defrecord Nakama [id image plus])

(defn parse-list
  [{team "npc"}]
  (mapv
   (fn [{id "base_npc_id" image "npc_id" pluses "quality"}]
     (->Nakama id image (js/parseInt pluses)))
   (vals team)))
