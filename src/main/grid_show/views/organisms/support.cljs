(ns grid-show.views.organisms.support
  (:require [grid-show.state :as state]
            [grid-show.views.molecules.plusable :as plusable]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $wrap
  (css {:flex-basis "100%"
        :display "flex"
        :flex-flow "column nowrap"
        :align-items "center"
        :justify-content "end"}))

(def $image
  (css {:width "100px"
        :margin "0 auto"}))

(def $level
  (css {:width "100%"
        :text-align "center"}))

(defn view
  []
  (when-let [{:keys [image level plus]} @(rf/subscribe [::state/supporter])]
    [:div
     {:class [$wrap]}
     [:div
      [:span
       "Supporter"]]
     [:div
      {:class [$image]}
      [plusable/view
       plus
       [:img
        {:src (str "https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/assets/summon/party_main/"
                   image
                   ".jpg")}]]
      [:div
       {:class [$level]}
       [:span
        (str "Lv" level)]]]]))
