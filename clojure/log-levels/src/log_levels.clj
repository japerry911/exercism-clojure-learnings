(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (let [parts (str/split s #":")]
    (str/trim (nth parts 1))))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [parts (str/split s #":")]
    (str/lower-case (str/replace (nth parts 0) #"[\[\]]" ""))))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")"))
