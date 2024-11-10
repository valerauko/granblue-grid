(ns grid-show.scenes.atoms.plusable
  (:require [grid-show.views.atoms.plusable :as plusable]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export plusable-vertical
  [:div
   {:style {:width "min-content"}}
   [plusable/view
    69
    [:div
     {:style {:width "60px"
              :height "120px"
              :background "black"}}]]])

(defscene ^:export plusable-grid
  [:div
   {:style {:width "min-content"}}
   [plusable/view
    69
    [:div
     {:style {:width "95px"
              :height "55px"
              :background "black"}}]]])

(defscene ^:export plusable-large
  [:div
   {:style {:width "min-content"}}
   [plusable/view
    69
    [:div
     {:style {:width "105px"
              :height "180px"
              :background "black"}}]]])
