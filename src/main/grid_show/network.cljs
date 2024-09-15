(ns grid-show.network
  (:require [grid-show.state :as state]
            [re-frame.core :as rf]))

(defn listener
  [^js request]
  (when-some [url (some-> request .-request .-url)]
    (cond
      (.includes url "decks_info")
      (.getContent
       request
       #(rf/dispatch [::state/update-deck-info %]))

      (or (.includes url "create_quest")
          (.includes url "questskip"))
      (when-let [request-data (some-> request .-request .-postData .-text)]
        (rf/dispatch [::state/start-quest request-data]))

      (.includes url "raid_deck_data_create")
      (when-let [request-data (some-> request .-request .-postData .-text)]
        (rf/dispatch [::state/join-raid request-data])))))
