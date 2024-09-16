(ns grid-show.models.nakama)

(defrecord Nakama [id image plus])

(defn parse-list
  [{team "npc"}]
  (mapv
   (fn [{id "base_npc_id" image "npc_id" pluses "quality"}]
     (->Nakama id image (js/parseInt pluses)))
   (vals team)))

(defn parse-detail
  [{{team "npc"} "deck"}]
  (mapv
   (fn [{{:strs [id]} "master"
         {image "image_id_3" pluses "quality" :strs [level]} "param"}]
     (assoc (->Nakama id image (js/parseInt pluses))
            :level (js/parseInt level)))
   (vals team)))
