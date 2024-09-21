(ns grid-show.views.molecules.bullets
  (:require [shadow.css :refer [css]]))

(def $bullet-grid
  (css {:display "flex"
        :flex-flow "row wrap"
        :gap "5px"
        :justify-content "center"}
       ["& > div"
        {:height "40px"}]
       ["& > div > img"
        {:height "inherit"}]))

(defn view
  [{:keys [bullets]}]
  (when (not (empty? bullets))
    (into
     [:div
      {:class [$bullet-grid]}]
     (map
      (fn [{:keys [image]}]
        [:div
         [:img
          {:src (str "https://prd-game-a1-granbluefantasy.akamaized.net/assets/img/sp/assets/bullet/s/"
                     image
                     ".jpg")}]]))
     bullets)))
