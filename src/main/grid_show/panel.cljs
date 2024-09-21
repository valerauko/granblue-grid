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
  (if js/chrome.devtools
    (js/chrome.devtools.network.onRequestFinished.addListener network/listener)
    (js/console.warn "DevTools isn't available. If you're developing, either mock everything or use Portfolio."))

  (remount)
  (js/console.debug "GBF Grid Show panel init complete"))
