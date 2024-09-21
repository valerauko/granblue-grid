(ns grid-show.scenes.layout
  (:require [grid-show.views.layout :as layout]
            [portfolio.reagent-18 :refer-macros [defscene]]
            [re-frame.db :refer [app-db]]))

(defscene ^:export soldier
  :on-mount
  (fn [_]
    (reset!
     app-db
     {:grid-show.state/decks
      {"15" {:id "15",
             :job {:id "240301",
                   :image "240201_gu_1_01",
                   :skills [{:id "200591", :name "フォーティチュード"}
                            {:id "200601", :name "ゲリーリャ"}
                            {:id "7221", :name "トライン"}],
                   :bullets [{:image "31301"} {:image "20105"} {:image "10105"} {:image "10105"} {:image "41104"} {:image "41104"}]},
             :team [{:id "3040392000", :image "3040392000_01", :plus 0, :level 80}
                    {:id "3040441000", :image "skin/3710213000_01_s5", :plus 0, :level 80}
                    {:id "3040393000", :image "3040393000_01", :plus 0, :level 80}
                    {:id "3040038000", :image "3040038000_03", :plus 0, :level 100}
                    {:id "3040477000", :image "3040477000_01", :plus 0, :level 80}],
             :weapons {"1" {:id "1040511000", :image "1040511000", :plus 0, :level "200", :skill-level "SP", :skills [{:id "1288", :image "skill_job_weapon"} {:id "1289", :image "skill_job_weapon"}]},
                       "2" {:id "1040814500", :image "1040814500", :plus 0, :level "150", :skill-level "15", :skills [{:id "1792", :image "skill_job_weapon"} {:id "1848", :image "skill_job_weapon"} {:id "1784", :image "skill_job_weapon"}]},
                       "3" {:id "1040007200", :image "1040007200", :plus 0, :level "200", :skill-level "20", :skills [{:id "306", :image "skill_god_m_5"} {:id "5", :image "skill_atk_5_1"}]},
                       "4" {:id "1040511600", :image "1040511600", :plus 0, :level "200", :skill-level "20", :skills [{:id "1539", :image "skill_xeno_5_4"} {:id "1326", :image "skill_job_weapon"}]},
                       "5" {:id "1040309000", :image "1040309000", :plus 99, :level "150", :skill-level "15", :skills [{:id "630", :image "skill_atk_5_4_3"} {:id "1091", :image "skill_deadly_5_2"}]},
                       "6" {:id "1040007200", :image "1040007200", :plus 0, :level "200", :skill-level "20", :skills [{:id "306", :image "skill_god_m_5"} {:id "5", :image "skill_atk_5_1"}]},
                       "7" {:id "1040313000", :image "1040313000", :plus 0, :level "150", :skill-level "15", :skills [{:id "1553", :image "skill_ta_5_4"} {:id "1554", :image "skill_job_weapon"}]},
                       "8" {:id "1040708400", :image "1040708400", :plus 0, :level "150", :skill-level "15", :skills [{:id "944", :image "skill_whole_m_5_2"} {:id "945", :image "skill_will_m_5_1"}]},
                       "9" {:id "1040017100", :image "1040017100", :plus 0, :level "200", :skill-level "20", :skills [{:id "1238", :image "skill_god_m_5_3"} {:id "1240", :image "skill_normal_limit"} {:id "1735", :image "skill_god_m_5_2"}]},
                       "10" {:id "1040809600", :image "1040809600", :plus 0, :level "150", :skill-level "15", :skills [{:id "1252", :image "skill_seraphic_5_3"} {:id "378", :image "skill_god_5"}]}},
             :summons {:main {:id "2040047000", :image "2040047000_04", :level "250", :plus 99},
                       :grid {"2" {:id "2040003000", :image "2040003000_04", :level "250", :plus 99},
                              "3" {:id "2040381000", :image "2040381000", :level "100", :plus 0},
                              "4" {:id "2040180000", :image "2040180000", :level "150", :plus 0},
                              "5" {:id "2040319000", :image "2040319000", :level "200", :plus 0}},
                       :subs {"1" {:id "2040347000", :image "2040347000", :level "150", :plus 99},
                              "2" {:id "2040417000", :image "2040417000", :level "150", :plus 99}}}}},
      :grid-show.state/active "15"}))
  [_]
  [layout/view])
