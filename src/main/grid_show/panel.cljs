(ns grid-show.panel
  (:require [grid-show.network :as network]
            [grid-show.views.layout :as layout]
            [reagent.dom.client :as dom]
            [re-frame.core :as rf]))

(defn ^:dev/after-load remount
  []
  (rf/clear-subscription-cache!)
  (let [root-el (js/document.getElementById "root")]
    (dom/unmount (dom/create-root root-el))
    (dom/render (dom/create-root root-el) [layout/view])))

(defn ^:export init []
  (js/chrome.devtools.network.onRequestFinished.addListener network/listener)

  (remount)
  (js/console.debug "GBF Grid Show panel init complete"))
