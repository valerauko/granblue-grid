(ns grid-show.views.atoms.nakama
  (:require [grid-show.views.atoms.plusable :as plusable]))

(defn view
  [$class {:keys [image plus level]}]
  [:div
   {:class [$class]}
   [plusable/view
    plus
    [:img
     {:src (str "https://prd-game-a1-granbluefantasy.akamaized.net/assets/img/sp/assets/npc/quest/"
                image
                ".jpg")}]]
   (when level
     [:span
      (str "Lv" level)])])
