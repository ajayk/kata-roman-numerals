(ns fr.pingtimeout.codekata.romannumerals)

(use '[clojure.string :only (join)])

(def units-tokens
  (hash-map
    :previous-unit ""
    :one "I"
    :five "V"
    :ten "X"
    ))

(def tens-tokens
  (hash-map
    :previous-unit "I"
    :one "X"
    :five "L"
    :ten "C"
    ))

(def hundreds-tokens
  (hash-map
    :previous-unit "X"
    :one "C"
    :five "D"
    :ten "M"
    ))

(def thousands-tokens
  (hash-map
    :previous-unit "C"
    :one "M"
    :five ""
    :ten ""
    ))

(def tokens (hash-map
  :units units-tokens
  :tens tens-tokens
  :hundreds hundreds-tokens
  :thousands thousands-tokens
  ))

(defn parse-integer [str]
  ^{:doc "Parse the given character as an integer"}
  (try (Integer/parseInt str)
    (catch NumberFormatException nfe 0)))

(defn split-string-to-number-array [roman-numbers-string]
  ^{:doc "Split the given string in an array of integers"}
  (let [string-length (.length roman-numbers-string)]
    (cond
      (= string-length 0) []
      :else (cons
      (parse-integer (.substring roman-numbers-string 0 1))
      (split-string-to-number-array (.substring roman-numbers-string 1))
      ))))

(defn to-4-elements-array [some-array]
  ^{:doc "Transform the given integer array in a 4 elements array. Truncate the array if it contains more that 4 elements. Add 0 integers to the left of the array if it contains less that 4 elements"}
  (let [array-length (count some-array)]
    (cond
      (< array-length 4) (to-4-elements-array (conj some-array 0))
      (= array-length 4) some-array
      (> array-length 4) (to-4-elements-array (rest some-array))
      )))

(defn roman-number-to-array [roman-number]
  ^{:doc "Parse the given string in an array of 4 elements"}
  (to-4-elements-array (split-string-to-number-array roman-number)))

(defn associate-symbols [roman-numbers-list]
  ^{:doc "Transform the given list in a map associating each element with a symbol (:units, :tens, :hundreds, :thousands)"}
  (zipmap [:thousands :hundreds :tens :units] roman-numbers-list))

(defn roman-number-to-map [roman-number]
  ^{:doc "Parse the given string in an associated map of numbers"}
  (associate-symbols (roman-number-to-array roman-number)))

(defn convert-digit [digit unit]
  ^{:doc "Convert the given digit according to the given unit"}
  (cond
    (< digit 4) (join (repeat digit ((tokens unit) :one)))
    (= digit 4) (str (convert-digit 1 unit) (convert-digit 5 unit))
    (= digit 5) ((tokens unit) :five)
    (< digit 9) (str (convert-digit 5 unit) (convert-digit (- digit 5) unit))
    (= digit 9) (str (convert-digit 1 unit) ((tokens unit) :ten))
    ))

(defn convert-associated-map-of-digits [map-of-digits]
  ^{:doc "Convert the given map of digits"}
  (str
    (convert-digit (map-of-digits :thousands) :thousands)
    (convert-digit (map-of-digits :hundreds) :hundreds)
    (convert-digit (map-of-digits :tens) :tens)
    (convert-digit (map-of-digits :units) :units)
    ))

(defn convert-number [roman-number]
  ^{:doc "Convert the given number in a roman number"}
  (convert-associated-map-of-digits (roman-number-to-map roman-number)))

