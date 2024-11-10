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
  [{bullets "bullet_info"
    {{familiar "familiar_id"
      _shield "shield_id"
      {:strs [image]} "param"
      {{:strs [id]} "master"} "job"
      skills "set_action"} "pc"} "deck"}]
  (cond->
   (->Job id image (into [] (comp (filter map?)
                                  (map (fn [{id "set_action_id" :strs [name]}]
                                         (->Skill id name)))) skills))
    (not (empty? bullets))
    (assoc :bullets
           (transduce
            (comp (map #(get-in bullets ["set_bullets" (str "bullet_" %)]))
                  (filter some?))
            (completing
             (fn [aggr {id "bullet_id"}]
               (conj aggr {:image id})))
            []
            (let [max-count (js/parseInt (get-in bullets ["set_bullets" "max_set_count"]))]
              (range 1 (inc max-count)))))

    (pos? familiar)
    (assoc :familiar familiar)))
