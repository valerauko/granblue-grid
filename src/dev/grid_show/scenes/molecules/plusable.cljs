(ns grid-show.scenes.molecules.plusable
  (:require [grid-show.views.molecules.plusable :as plusable]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export plusable
  [plusable/view
   [:div]])
