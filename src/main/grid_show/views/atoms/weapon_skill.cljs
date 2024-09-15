(ns grid-show.views.atoms.weapon-skill
  (:require [shadow.css :refer [css]]))

(def $icon
  (css {:width "30px"
        :height "30px"}))

(defn view
  [& _]
  [:img
   {:src "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/icon/skill/skill_god_m_3_3.png"
    :class [$icon]}])
