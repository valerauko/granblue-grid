(ns grid-show.scenes
  (:require [portfolio.ui]
            [grid-show.scenes.atoms.skill]
            [grid-show.scenes.molecules.plusable]))

(defonce ^:export app
  (portfolio.ui/start!))

(defn ^:export init [])
