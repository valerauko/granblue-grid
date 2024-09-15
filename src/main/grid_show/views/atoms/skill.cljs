(ns grid-show.views.atoms.skill
  (:require [shadow.css :refer [css]]))

(def $skill
  (css {:background-image "url('/skill_bg.png')"
        :background-position "right"
        :background-repeat "no-repeat"
        :width "260px"
        :height "50px"
        :display "flex"
        :align-items "center"
        :padding "10px 15px"
        :justify-content "center"}))

(def $skill-name
  (css {:overflow "hidden"
        :text-wrap "nowrap"
        :white-space "nowrap"
        :text-overflow "ellipsis"}))

(defn view
  [skill]
  [:div
   {:class [$skill]}
   [:span
    {:class [$skill-name]}
    (str (:name skill))]])
