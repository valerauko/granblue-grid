(ns grid-show.views.molecules.weapon
  (:require [grid-show.views.atoms.awakening :as awakening]
            [grid-show.views.atoms.plusable :as plusable]
            [grid-show.views.atoms.weapon.skill :as weapon-skill]
            [shadow.css :refer [css]]))

(def $grid-item
  (css {:width "95px"}))

(def $main
  (css {:width "90px"
        :grid-area "main"
        :align-self "center"}))

(def $skills
  (css {:display "flex"
        :flex-flow "row nowrap"
        :justify-content "space-evenly"}))

(def $level
  (css {:text-align "center"}))

(def main
  {:$class $main
   :prefix "ls"})

(def grid
  {:$class $grid-item
   :prefix "m"})

(defn view
  [{:keys [$class prefix]} {:keys [image plus skills level skill-level awakening]}]
  [:div
   {:class [$class]}
   [plusable/view
    plus
    [awakening/view
     awakening
     [:img
      {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/weapon/"
                 prefix "/"
                 (or image 1999999999)
                 ".jpg")}]]]
   (into
    [:div
     {:class [$skills]}]
    (map (fn [skill] [weapon-skill/view skill]))
    skills)
   (when level
     [:div
      {:class [$level]}
      (str "Lv" level " SLv" skill-level)])])
