(ns grid-show.views.organisms.job
  (:require [grid-show.views.atoms.skill :as skill]
            [grid-show.state :as state]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $wrap
  (css {:background-position "0 -40px"
        :background-repeat "no-repeat"
        :width "640px"
        :height "872px"
        :position "relative"}))

(def $link
  (css {:z-index "1"
        :display "block"
        :position "absolute"
        :width "400px"
        :height "600px"}))

(def $name
  (css {:z-index "0"
        :position "absolute"
        :left "15px"
        :top "10px"}))

(def $skills
  (css {:position "absolute"
        :right "25px"
        :top "20px"
        :display "none"}))

(def $skill
  (css {:overflow "hidden"
        :text-wrap "nowrap"
        :white-space "nowrap"
        :text-overflow "ellipsis"}))

(def $over
  (css {:position "absolute"
        :z-index "2"
        :width "100%"
        :height "100%"}))

(defn view
  [child]
  (let [job @(rf/subscribe [::state/job])]
    [:div
     {:class [$wrap]
      :style
      {:background-image
       (str "url('https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/leader/pm/"
            (:image job)
            ".png')")}}
     [:a
      {:class [$link]
       :href "#"}
      [:img
       {:class [$name]
        :src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/job_name/job_list/"
                  (:id job)
                  ".png")}]]
     (into
      [:div
       {:class [$skills]}]
      (map skill/view)
      (:skills job))

     [:div
      {:class [$over]}
      child]]))
