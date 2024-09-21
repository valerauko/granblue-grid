(ns grid-show.scenes.atoms.weapon.skill
  (:require [grid-show.models.weapon :refer [->Skill]]
            [grid-show.views.atoms.weapon.skill :as skill]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export dirt-magna-3
  [skill/view (->Skill 2294 "skill_magna_3")])

(defscene ^:export job-special
  [skill/view (->Skill 1048 "skill_job_weapon")])

(defscene ^:export progression-pendulum
  [skill/view (->Skill 1208 "skill_job_weapon")])

(defscene ^:export freyr-chain
  [skill/view (->Skill 1723 "skill_job_weapon")])

(defscene ^:export forbiddance-chain
  [skill/view (->Skill 1724 "skill_job_weapon")])

(defscene ^:export depravity-chain
  [skill/view (->Skill 1725 "skill_job_weapon")])

(defscene ^:export falsehood-chain
  [skill/view (->Skill 1726 "skill_job_weapon")])

;; (defscene ^:export extremity-pendulum
;;   [skill/view (->Skill 1726 "skill_job_weapon")])

;; (defscene ^:export sagacity-pendulum
;;   [skill/view (->Skill 1726 "skill_job_weapon")])

;; (defscene ^:export supremacy-pendulum
;;   [skill/view (->Skill 1726 "skill_job_weapon")])
