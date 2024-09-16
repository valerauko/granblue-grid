(ns grid-show.views.organisms.weapons
  (:require [grid-show.state :as state]
            [grid-show.views.molecules.weapon :as weapon]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $wrap
  (css {:border-image-source "url('https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/frame/bg.png?1511244036')"
        :border-image-slice "40 0 42 fill"
        :border-top-width "20px"
        :border-bottom-width "20px"
        :height "min-content"
        :width "min-content"
        :display "grid"
        :grid-template-areas
        "\"main list\"
         \". subs\""
        :padding "0 20px"
        :gap "5px"}))

(def $grid
  (css {:grid-area "list"
        :display "grid"
        :grid-template-rows "repeat(3, 1fr)"
        :grid-template-columns "repeat(3, 1fr)"
        :grid-column-gap "5px"
        :grid-row-gap "5px"}))

(def $subs
  (css {:grid-area "subs"
        :display "grid"
        :grid-template-rows "1"
        :grid-template-columns "repeat(3, 1fr)"
        :grid-column-gap "5px"}))

(defn view
  []
  (let [{main "1" :as weapons} @(rf/subscribe [::state/weapons])]
    [:div
     {:class [$wrap]}
     [weapon/view weapon/main main]
     (into
      [:div
       {:class [$grid]}]
      (comp
       (map #(get weapons (str %)))
       (map (fn [weapon] [weapon/view weapon/grid weapon])))
      ;; 2 to 10
      (range 2 11))
     (into
      [:div
       {:class [$subs]}]
      (comp
       (map #(get weapons (str %)))
       (map (fn [weapon] [weapon/view weapon/grid weapon])))
      ;; 11 to 13
      (range 11 14))]))
