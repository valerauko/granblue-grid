(ns grid-show.views.atoms.awakening
  (:require [shadow.css :refer [css]]))

(def $wrap
  (css {:position "relative"}))

(def $awakening
  (css {:position "absolute"
        :bottom "19px"
        :left "-3px"}))

(def $badge
  (css {:width "28px"
        :height "auto"}))

(defn view
  [awakening child]
  [:div
   {:class [$wrap]}
   child
   (when awakening
     [:div
      {:class [$awakening]}
      [:img
       {:class [$badge]
        :src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/icon/arousal_type/type_"
                  awakening ".png")}]])])
