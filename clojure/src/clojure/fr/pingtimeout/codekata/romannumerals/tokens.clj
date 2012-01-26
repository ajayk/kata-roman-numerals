(ns fr.pingtimeout.codekata.romannumerals.tokens)

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

