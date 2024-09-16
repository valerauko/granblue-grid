(ns grid-show.models.weapon)

(defrecord Skill [id image])
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
       (when-let [{:strs [id image]} (get data (str "skill" i))]
         (->Skill id image))))
    (filter some?))
   [1 2 3]))

(defn deck-detail->Weapon
  [{{:strs [id]} "master"
    {:strs [level]
     skill-level "skill_level"
     image "image_id"
     plus "quality"} "param" :as data}]
  (assoc (->Weapon id image (js/parseInt plus))
         :level level
         :skill-level skill-level
         :skills (deck-detail->Skills data)))
