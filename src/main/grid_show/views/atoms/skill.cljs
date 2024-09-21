(ns grid-show.views.atoms.skill
  (:require [shadow.css :refer [css]]))

(def $skill
  (css {:overflow "hidden"
        :text-wrap "nowrap"
        :white-space "nowrap"
        :text-overflow "ellipsis"
        :padding "5px 10px"}
       ["& + &"
        {:border-top "1px solid #876"}]))

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
