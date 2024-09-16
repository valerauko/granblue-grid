(ns grid-show.models.npc)

(defrecord Npc [id image plus])

(defn parse-list
  [{team "npc"}]
  (mapv
   (fn [{id "base_npc_id" image "npc_id" pluses "quality"}]
     (->Npc id image (js/parseInt pluses)))
   (vals team)))
