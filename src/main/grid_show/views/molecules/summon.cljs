(ns grid-show.views.molecules.summon
  (:require [grid-show.views.atoms.plusable :as plusable]
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
     {:src (str "https://prd-game-a"
                (when image 1)
                "-granbluefantasy.akamaized.net/assets/img/sp/assets/summon/ls/"
                (or image 2999999999)
                ".jpg")}]]
   (when level
     [:span
      (str "Lv " level)])])
