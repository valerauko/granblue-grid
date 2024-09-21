(ns grid-show.views.layout
  (:require [grid-show.state :as state]
            [grid-show.views.organisms.job :as job]
            [grid-show.views.organisms.team :as team]
            [grid-show.views.organisms.summons :as summons]
            [grid-show.views.organisms.support :as support]
            [grid-show.views.organisms.weapons :as weapons]
            [shadow.css :refer [css]]
            [re-frame.core :as rf]))

(def $background
  (css {:background-color "black"
        :display "flex"
        :align-items "center"
        :justify-content "center"
        :width "100%"
        :height "100vh"
        :min-height "860px"
        :color "white"
        :text-shadow "0 0 2px black, 0 0 2px black, 0 0 2px black, 0 0 2px black, 0 0 2px black, 0 0 2px black, 0 0 2px black, 0 0 2px black"
        :font-weight "500"
        :font-size "14px"}))

(def $wrap
  (css {:position "relative"}))

(def $flex
  (css {:width "100%"
        :height "100%"
        :display "flex"
        :flex-flow "column wrap"
        :justify-content "end"
        :align-items "end"
        :padding "20px 22px 31px 25px"}))

(defn view
  []
  [:div
   {:class [$background]}
   (if @(rf/subscribe [::state/active-deck?])
     [:div
      {:class [$wrap]}
      [job/view
       [:div
        {:class [$flex]}
        [support/view]
        [team/view]
        [summons/view]
        [weapons/view]]]]
     [:div "Start a quest to show your active team"])])
