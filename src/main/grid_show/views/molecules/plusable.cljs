(ns grid-show.views.molecules.plusable
  (:require [shadow.css :refer [css]]))

(def $wrap
  (css {:position "relative"}))

(def $plus
  (css {:position "absolute"
        :bottom "0"
        :right "5px"
        :color "#ff5"}))

(defn view
  [plus child]
  [:div
   {:class [$wrap]}
   child
   (when (pos? plus)
     [:div
      {:class [$plus]}
      (str "+" plus)])])
