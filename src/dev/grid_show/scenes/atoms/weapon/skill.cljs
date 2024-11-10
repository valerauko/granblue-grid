(ns grid-show.scenes.atoms.weapon.skill
  (:require [grid-show.models.weapon :refer [->Skill]]
            [grid-show.views.atoms.weapon.skill :as skill]
            [portfolio.reagent-18 :refer-macros [defscene]]))

(defscene ^:export dirt-magna-3
  [skill/view (->Skill 2294 "skill_magna_3" "マグナブースト・アース")])

(defscene ^:export job-special
  [skill/view (->Skill 889 "skill_job_weapon" "大盗の賦性")])

(defscene ^:export progression-pendulum
  [skill/view (->Skill 1208 "skill_job_weapon" "進境")])

(defscene ^:export freyr-chain
  [skill/view (->Skill 1723 "skill_job_weapon" "狡知の誘惑")])

(defscene ^:export forbiddance-chain
  [skill/view (->Skill 1724 "skill_job_weapon" "禁忌の果実")])

(defscene ^:export depravity-chain
  [skill/view (->Skill 1725 "skill_job_weapon" "邪悪と罪")])

(defscene ^:export falsehood-chain
  [skill/view (->Skill 1726 "skill_job_weapon" "虚偽と詐術")])

;; (defscene ^:export extremity-pendulum
;;   [skill/view (->Skill 1726 "skill_job_weapon")])

;; (defscene ^:export sagacity-pendulum
;;   [skill/view (->Skill 1726 "skill_job_weapon")])

;; (defscene ^:export supremacy-pendulum
;;   [skill/view (->Skill 1726 "skill_job_weapon")])

(defscene ^:export tria-key
  [skill/view (->Skill 1809 "skill_job_weapon" "フルゴル・インペトゥス")])
