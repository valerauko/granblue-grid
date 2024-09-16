(ns grid-show.views.atoms.weapon.skill
  (:require [shadow.css :refer [css]]))

(def $icon
  (css {:width "30px"
        :height "30px"}))

(defn view
  [{:keys [image]}]
  [:img
   {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/icon/skill/"
              image
              ".png")
    :class [$icon]}])
