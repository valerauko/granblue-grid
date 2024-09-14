(ns grid-show.views.organisms.job
  (:require [grid-show.state :as state]
            [grid-show.views.atoms.skill :as skill]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $wrap
  (css {:position "relative"}))

(def $image
  (css {}))

(def $details
  (css {:position "absolute"
        :right "0"
        :top "0"
        :padding "15px"}))

(defn view
  []
  (let [job @(rf/subscribe [::state/job])]
    (js/console.debug (clj->js (:skills job)))
    [:div
     {:class [$wrap]}
     [:img
      {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/leader/p/"
                 (:image job)
                 ".png")
       :draggable false
       :class [$image]}]
     (into
      [:div
       {:class [$details]}]
      (map skill/view)
      (:skills job))]))
