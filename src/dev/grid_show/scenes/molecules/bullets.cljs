(ns grid-show.scenes.molecules.bullets
  (:require [grid-show.views.molecules.bullets :as bullets]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export john-doe
  [:div
   {:style {:width "160px"}}
   [bullets/view
    {:bullets [{:image 31301}
               {:image 20105}
               {:image 10105}
               {:image 10105}
               {:image 41104}
               {:image 41104}]}]])
