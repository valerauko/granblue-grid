(ns grid-show.dev
  (:require [shadow.cljs.devtools.api :as shadow]
            [grid-show.css :as css]))

(defn ^:export watch
  {:shadow/requires-server true}
  [& _]
  (shadow/watch :ext)
  (shadow/watch :portfolio)
  (css/watch))
