(ns demo.tab)

(defn init []
  (js/chrome.devtools.panels.create
   "GBF Grid Show"
   "drink_water16.png"
   "panel.html"
   (fn [_])))
