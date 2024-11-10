(ns grid-show.scenes
  (:require [portfolio.ui]
            [grid-show.scenes.atoms.awakening]
            [grid-show.scenes.atoms.plusable]
            [grid-show.scenes.atoms.skill]
            [grid-show.scenes.atoms.weapon.skill]
            [grid-show.scenes.layout]
            [grid-show.scenes.molecules.bullets]))

(defonce ^:export app
  (portfolio.ui/start!
   {:config
    ;; it's not /css/ because :dev-http serves from ext/css already
    {:css-paths ["/ui.css"]}}))

(defn ^:export init [])
