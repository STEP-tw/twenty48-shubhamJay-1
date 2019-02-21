(ns twenty48.core
  (:gen-class))

(def add-combinations (partial map (partial apply +)))

(def combinations-to-add (comp
                          (partial mapcat (partial partition-all 2))
                          (partial partition-by identity)))

(def add-consecutive-equal-element (comp
                                    add-combinations
                                    combinations-to-add))

(def filter-zeros (partial remove zero?))

(defn fill-zeros-to-right [row] (take 4 (concat row (repeat 0))))

(def turn-grid (partial apply map vector))

(def move-left (comp
                fill-zeros-to-right
                add-consecutive-equal-element
                filter-zeros))

; "Moves an entire grid to the right"
(def move-grid-right (partial map (comp reverse move-left reverse)))

; "Moves an entire grid to the left"
(def move-grid-left (partial map move-left))

; "Moves an entire grid down"
(def move-grid-down (comp
                     turn-grid
                     move-grid-right
                     turn-grid))

; "Moves an entire grid up"
(def move-grid-up (comp
                   turn-grid
                   move-grid-left
                   turn-grid))
