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
       ;; if the network devtools tab is open and recording,
       ;; after a while resources get "lost" probably due to some
       ;; memory management issue (not related to this extension)
       ;; errors are "Frame tree node for given frame not found"
       ;; and "Extension server error: Object not found"
       #(when-let [data %]
          (rf/dispatch [::state/update-deck-info data])))

      (or (.endsWith url "party/deck")
          (.includes url "party/deck/")
          (.includes url "party/deck?"))
      (.getContent
       request
       #(when-let [data %]
          (rf/dispatch [::state/update-deck-detail data])))

      (or (.includes url "create_quest")
          (.includes url "questskip"))
      (when-let [request-data (some-> request .-request .-postData .-text)]
        (rf/dispatch [::state/start-quest request-data]))

      (.includes url "raid_deck_data_create")
      (when-let [request-data (some-> request .-request .-postData .-text)]
        (rf/dispatch [::state/join-raid request-data])))))
