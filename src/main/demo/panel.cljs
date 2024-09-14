(ns demo.panel
  (:require [cognitect.transit :as t]))

(defonce state
  (atom {}))

(defn index-by
  [coll f]
  (->> coll
       (reduce
        (fn [aggr item]
          (assoc! aggr (f item) item))
        (transient {}))
       persistent!))

(defn init []
  (js/chrome.devtools.network.onRequestFinished.addListener
   (fn response-listener
     [request]
     (when-some [url (some-> request .-request .-url)]
       (cond
         (.includes url "decks_info")
         (.getContent
          request
          (fn deck-handler
            [body]
            (let [decoder (t/reader :json)
                  {:strs [supporter] :as data} (t/read decoder body)
                  decks (some-> data
                                (get "deck_list")
                                vals
                                (index-by (fn [{group "group_priority" deck "priority"}]
                                            (str group deck))))]
              (js/console.debug "Supporter:" (clj->js supporter))
              (js/console.debug "Decks:" (clj->js decks))
              (swap!
               state
               (fn [old-state]
                 (-> old-state
                     (assoc ::supporter supporter
                            ::decks decks)))))))

         (.includes url "create_quest")
         (when-let [request-data (some-> request .-request .-postData .-text)]
           (let [decoder (t/reader :json)
                 deck (-> (t/read decoder request-data) (get "deck_id") str)]
             (js/console.debug "Deck id:" deck)
             (js/console.debug "Active deck" (clj->js (get-in @state [::decks deck])))))))))

  (js/console.debug "GBF Grid Show panel init complete"))
