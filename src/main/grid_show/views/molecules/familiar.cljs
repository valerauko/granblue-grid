(ns grid-show.views.molecules.familiar
  (:require [shadow.css :refer [css]]))

(def $familiar
  (css {:width "140px"}
       ["& > img"
        {:width "inherit"
         :height "auto"}]))

(defn view
  [{:keys [familiar]}]
  (when familiar
    [:div
     {:class [$familiar]}
     [:img
      {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/familiar/m/"
                 familiar ".jpg")}]]))
