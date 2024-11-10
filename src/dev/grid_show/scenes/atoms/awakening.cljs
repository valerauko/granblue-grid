(ns grid-show.scenes.atoms.awakening
  (:require [grid-show.views.atoms.awakening :as awakening]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export awakening-grid
  [:div
   {:style {:width "min-content"}}
   [awakening/view
    1
    [:div
     {:style {:width "95px"
              :height "55px"
              :background "black"}}]]])

(defscene ^:export awakening-large
  [:div
   {:style {:width "min-content"}}
   [awakening/view
    2
    [:div
     {:style {:width "105px"
              :height "180px"
              :background "black"}}]]])
