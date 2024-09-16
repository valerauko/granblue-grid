(ns grid-show.views.atoms.summon
  (:require [grid-show.views.molecules.plusable :as plusable]
            [shadow.css :refer [css]]))

(def $summon
  (css {:width "50px"
        :text-align "center"}))

(defn view
  [{:keys [image level plus]}]
  [:div
   {:class [$summon]}
   [plusable/view
    plus
    [:img
     {:src (str "https://prd-game-a1-granbluefantasy.akamaized.net/assets/img/sp/assets/summon/ls/"
                (or image 1999999999)
                ".jpg")}]]
   [:span
    (str "Lv " level)]])
