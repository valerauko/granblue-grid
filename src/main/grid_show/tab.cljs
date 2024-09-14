(ns grid-show.tab)

(defn ^:export init []
  (js/chrome.devtools.panels.create
   "GBF Grid Show"
   "drink_water16.png"
   "index.html"
   (fn [_])))
