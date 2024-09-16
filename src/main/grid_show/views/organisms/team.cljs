(ns grid-show.views.organisms.team
  (:require [grid-show.state :as state]
            [grid-show.views.atoms.nakama :as nakama]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $wrap
  (css {:border-image-source "url('https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/frame/bg.png?1511244036')"
        :border-image-slice "40 0 42 fill"
        :border-top-width "20px"
        :border-bottom-width "20px"
        :height "min-content"
        :width "min-content"
        :margin-bottom "auto"
        :display "flex"
        :flex "row nowrap"
        :gap "5px"
        :padding "0 20px"}))

(def $nakama
  (css {:width "50px"
        :text-align "center"}
       ["&:nth-child(3)"
        {:margin-right "5px"}]))

(defn view
  []
  (let [team @(rf/subscribe [::state/team])]
    (into
     [:div
      {:class [$wrap]}]
     (map (fn [npc] [nakama/view $nakama npc]))
     team)))
