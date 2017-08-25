lein repl :connect 7888
(require '[alfresco.auth :as a])
(require '[alfresco.search :as s])
(require '[alfresco.nodes :as n])

(def company-home 
    (a/as-admin
     (first
       (s/query "PATH:\"/*\" AND TYPE:\"cm:folder\""))))
        
(clojure.pprint/pprint
  (a/as-admin
    (n/properties company-home)))
