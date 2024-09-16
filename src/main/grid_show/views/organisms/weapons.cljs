(ns grid-show.views.organisms.weapons
  (:require [grid-show.state :as state]
            [grid-show.views.atoms.weapon-skill :as weapon-skill]
            [grid-show.views.molecules.plusable :as plusable]
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

(def $grid-item
  (css {:width "95px"}))

(def $grid
  (css {:grid-area "list"
        :display "grid"
        :grid-template-rows "repeat(3, 1fr)"
        :grid-template-columns "repeat(3, 1fr)"
        :grid-column-gap "5px"
        :grid-row-gap "5px"}))

(def $main
  (css {:width "90px"
        :grid-area "main"
        :align-self "center"}))

(def $subs
  (css {:grid-area "subs"
        :display "grid"
        :grid-template-rows "1"
        :grid-template-columns "repeat(3, 1fr)"
        :grid-column-gap "5px"}))

(def $skills
  (css {:display "flex"
        :flex "row nowrap"
        :justify-content "center"}))

(defn view
  []
  (let [weapons @(rf/subscribe [::state/weapons])
        [main & others] (vals weapons)]
    [:div
     {:class [$wrap]}
     [:div
      {:class [$main]}
      [plusable/view
       (:plus main)
       [:img
        {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/weapon/ls/"
                   (:image main 1999999999)
                   ".jpg")}]]
      [:div
       {:class [$skills]}
       [weapon-skill/view]
       [weapon-skill/view]
       [weapon-skill/view]]
      [:span
       "SLv 20"]]
     (into
      [:div
       {:class [$grid]}]
      (map
       (fn [{:keys [image plus]}]
         [:div
          {:class [$grid-item]}
          [plusable/view
           plus
           [:img
            {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/weapon/m/"
                       (or image 1999999999)
                       ".jpg")}]]
          [:div
           {:class [$skills]}
           [weapon-skill/view]
           [weapon-skill/view]
           [weapon-skill/view]]
          [:span
           "SLv 20"]]))
      (filter some? (take 9 others)))
     (into
      [:div
       {:class [$subs]}]
      (map
       (fn [{:keys [image plus]}]
         [:div
          {:class [$grid-item]}
          [plusable/view
           plus
           [:img
            {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/weapon/m/"
                       (or image 1999999999)
                       ".jpg")}]]
          [:div
           {:class [$skills]}
           [weapon-skill/view]
           [weapon-skill/view]
           [weapon-skill/view]]
          [:span
           "SLv 20"]]))
      (filter some? (drop 9 others)))]))
