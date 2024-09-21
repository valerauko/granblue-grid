(ns grid-show.scenes.molecules.plusable
  (:require [grid-show.views.molecules.plusable :as plusable]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export plusable
  [:div
   {:style {:width "min-content"}}
   [plusable/view
    69
    [:div
     {:style {:width "60px"
              :height "120px"
              :background "black"}}]]])
