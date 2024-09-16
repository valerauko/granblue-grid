(ns grid-show.models.job)

(defrecord Job [id image skills])
(defrecord Skill [id name])

(defn parse-list
  [{{id "master_id" image "job_id"} "job"
    skills "setaction"}]
  (->Job id image (into [] (comp (filter map?)
                                 (map (fn [{id "set_action_id" :strs [name]}]
                                        (->Skill id name)))) skills)))
