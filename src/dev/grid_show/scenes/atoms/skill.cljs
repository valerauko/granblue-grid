(ns grid-show.scenes.atoms.skill
  (:require [grid-show.views.atoms.skill :as skill]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export skill
  [skill/view {:name "Foo"}])
