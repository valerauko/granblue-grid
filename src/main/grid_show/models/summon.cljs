(ns grid-show.models.summon)

(defrecord Summon [id image level plus])
(defrecord Deck [main grid subs])

(defn support->Summon
  [{id "summon_id"
    image "summon_image_id"
    level "summon_level"
    plus "summon_quality"}]
  (when id
    (->Summon id image level (js/parseInt plus))))

(defn deck->Summon
  [{:strs [level]
    plus "quality"
    id "summon_id"
    image "image_id"}]
  (when id
    (->Summon id image level (js/parseInt plus))))

(defn detail->Summon
  [{{:strs [id]} "master"
    {image "image_id" plus "quality" :strs [level]} "param"}]
  (when id
    (->Summon id image level (js/parseInt plus))))

(defn parse-list
  [{summons "summon" subs "sub_summon"}]
  (->Deck
   (deck->Summon (get summons "1"))
   (update-vals (dissoc summons "1") deck->Summon)
   (update-vals subs deck->Summon)))

(defn parse-detail
  [{{{:strs [summons] subs "sub_summons"} "pc"} "deck"}]
  (->Deck
   (detail->Summon (get summons "1"))
   (update-vals (dissoc summons "1") detail->Summon)
   (update-vals subs detail->Summon)))
