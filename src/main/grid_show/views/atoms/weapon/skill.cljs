(ns grid-show.views.atoms.weapon.skill
  (:require [shadow.css :refer [css]]))

(def $icon
  (css {:width "30px"
        :height "30px"}))

(def skills
  {"1208" 14004 ;; progression / prosperity
   "1723" 14014 ;; freyr chain
   "1724" 14015 ;; forbiddance chain
   "1725" 14016 ;; depravity chain
   "1726" 14017 ;; falsehood chain
   })

(defn view
  [{:keys [id image name]}]
  (let [source
        (if-let [skill (skills (str id))]
          (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/item/skillplus/s/"
               skill
               ".jpg")
          (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/icon/skill/"
               image
               ".png"))]
    [:img
     {:src source
      :title (str name)
      :class [$icon]}]))
