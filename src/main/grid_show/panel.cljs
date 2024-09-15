(ns grid-show.panel
  (:require [grid-show.network :as network]
            [grid-show.views.layout :as layout]
            [reagent.dom]
            [re-frame.core :as rf]))

(defn ^:dev/after-load remount
  []
  (rf/clear-subscription-cache!)
  (let [root-el (js/document.getElementById "root")]
    (reagent.dom/unmount-component-at-node root-el)
    (reagent.dom/render [layout/view] root-el)))

(defn ^:export init []
  (js/chrome.devtools.network.onRequestFinished.addListener network/listener)

  (remount)
  (js/console.debug "GBF Grid Show panel init complete"))
