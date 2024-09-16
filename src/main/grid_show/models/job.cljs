(ns grid-show.models.job)

(defrecord Job [id image skills])
(defrecord Skill [id name])

(defn parse-list
  [{{id "master_id" image "job_id"} "job"
    skills "setaction"}]
  (->Job id image (into [] (comp (filter map?)
                                 (map (fn [{id "set_action_id" :strs [name]}]
                                        (->Skill id name)))) skills)))

(defn parse-detail
  [{_bullets "bullet_info"
    {{_familiar "familiar_id"
      _shield "shield_id"
      {:strs [image]} "param"
      {{:strs [id]} "master"} "job"
      skills "set_action"} "pc"} "deck"}]
  (->Job id image (into [] (comp (filter map?)
                                 (map (fn [{id "set_action_id" :strs [name]}]
                                        (->Skill id name)))) skills)))
