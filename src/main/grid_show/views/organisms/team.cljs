(ns grid-show.views.organisms.team
  (:require [grid-show.state :as state]
            [re-frame.core :as rf]
            [shadow.css :refer [css]]))

(def $border
  (css {}))

(def $wrap
  (css {:border-image-source "url('https://prd-game-a-granbluefantasy.akamaized.net/assets/img/sp/ui/frame/bg.png?1511244036')"
        :border-image-slice "20 0 22 fill"
        :border-top-width "20px"
        :border-bottom-width "20px"
        :display "flex"
        :flex "row nowrap"
        :justify-content "center"
        :padding "10px 20px"
        :gap "5px"}))

(def $nakama
  (css ["&:nth-child(3)"
        {:margin-right "10px"}]))

(defn view
  []
  (let [team @(rf/subscribe [::state/team])]
    [:div
     {:class [$border]}
     (into
      [:div
       {:class [$wrap]}]
      (map
       (fn [{:keys [id image]}]
         [:div
          {:class [$nakama]}
          [:a
           {:href (str "https://gbf.wiki/index.php?search=" id)
            :target "_blank"}
           [:img
            {:src (str "https://prd-game-a1-granbluefantasy.akamaized.net/assets/img/sp/assets/npc/quest/"
                       image
                       ".jpg")}]]]))
      team)]))
