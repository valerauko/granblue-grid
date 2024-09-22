(ns grid-show.models.weapon)

(defrecord Skill [id image name])
(defrecord Weapon [id image plus])

(defn deck-list->Weapon
  [{id "weapon_id"
    image "image_id"
    plus "quality"}]
  (when id
    (->Weapon id image (js/parseInt plus))))

(defn deck-detail->Skills
  [data]
  (into
   []
   (comp
    (map
     (fn [i]
       (when-let [{:strs [id image name]} (get data (str "skill" i))]
         (->Skill id image name))))
    (filter some?))
   [1 2 3]))

(defn deck-detail->skill-level
  [data]
  (let [active-skills
        (filter #(get data (str "skill" %)) [1 2 3])
        normal-skills
        (filter #(= "" (get-in data ["master" (str "skill" % "_display")])) active-skills)]
    (if (empty? normal-skills)
      "SP"
      (get-in data ["param" "skill_level"]))))

(defn deck-detail->Weapon
  [{{:strs [id]} "master"
    {:strs [level]
     image "image_id"
     plus "quality"} "param" :as data}]
  (assoc (->Weapon id image (js/parseInt plus))
         :level level
         :skill-level (deck-detail->skill-level data)
         :skills (deck-detail->Skills data)))
