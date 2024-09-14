(ns grid-show.collections)

(defn index-by
  [coll f]
  (->> coll
       (reduce
        (fn [aggr item]
          (assoc! aggr (f item) item))
        (transient {}))
       persistent!))
