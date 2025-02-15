(ns bob
  (:require [clojure.string :as str]))

(defn response-for [s] ;; <- arglist goes here
  (let [trimmed (str/trim s)]
    (cond
      (and (str/ends-with? trimmed "?") (= trimmed (str/upper-case trimmed))) "Calm down, I know what I'm doing!"
      (str/ends-with? trimmed "?") "Sure."
      (str/blank? trimmed) "Fine. Be that way!"
      (and (= trimmed (str/upper-case trimmed)) (> (count trimmed) 0)) "Whoa, chill out!"
      :else "Whatever.")))
