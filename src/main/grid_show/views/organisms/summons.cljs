(ns grid-show.views.organisms.summons
  (:require [grid-show.state :as state]
            [grid-show.views.molecules.summon :as summon]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $wrap
  (css {:border-image-source "url('https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/frame/bg.png?1511244036')"
        :border-image-slice "40 0 42 fill"
        :border-top-width "20px"
        :border-bottom-width "20px"
        :height "min-content"
        :width "min-content"
        :display "flex"
        :flex-flow "row nowrap"
        :padding "0 20px"
        :gap "10px"}))

(def $block
  (css {:display "flex"
        :flex-flow "row nowrap"
        :gap "5px"}))

(defn view
  []
  (let [{:keys [main grid subs]} @(rf/subscribe [::state/summons])]
    [:div
     {:class [$wrap]}
     [:div
      {:class [$block]}
      [summon/view main]]
     (into
      [:div
       {:class [$block]}]
      (map summon/view)
      (vals grid))
     (when (some some? (vals subs))
       (into
        [:div
         {:class [$block]}]
        (map summon/view)
        (vals subs)))]))
