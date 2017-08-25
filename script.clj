
;; start nrepol
curl -u admin:admin -X POST http://192.168.0.20:8080/alfresco/service/clojure/nrepl

;; stop nrepol
curl -u admin:admin -X DELETE http://192.168.0.20:8080/alfresco/service/clojure/nrepl

;; connect
lein repl :connect 192.168.0.20:7888
lein repl :connect 7888
    
(require '[alfresco.auth :as a])
(require '[alfresco.search :as s])
(require '[alfresco.nodes :as n])

(def company-home 
    (a/as-admin
     (first
       (s/query "PATH:\"/*\" AND TYPE:\"cm:folder\""))))
        


(str company-home)

(a/as-admin
  (do
    (println (n/site? company-home))
    (println (n/dir? company-home))
    (println (n/type-qname company-home))))


(clojure.pprint/pprint
  (a/as-admin
    (n/properties company-home)))
