(ns grid-show.collections)

(defn index-by
  [f coll]
  (->> coll
       (reduce
        (fn [aggr item]
          (assoc! aggr (f item) item))
        (transient {}))
       persistent!))
