(ns twenty48.core
  (:gen-class))

(def add-combinations (partial map (partial apply +)))

(def combinations-to-add (comp (partial mapcat (partial partition-all 2)) (partial partition-by identity)))

(def add-consecutive-equal-element (comp add-combinations combinations-to-add))

(def filter-zeros (partial filter (comp not (partial zero?))))

(defn fill-zeros-to-right [row] (take 4 (concat row (repeat 0))))

(def move-left (comp fill-zeros-to-right add-consecutive-equal-element filter-zeros))

; "Moves an entire grid to the right"
(def move-grid-right (comp (partial map (comp reverse move-left reverse))))

; "Moves an entire grid to the left"
(def move-grid-left (comp (partial map move-left)))

; "Moves an entire grid down"
(defn move-grid-down
  [grid]
  grid)

; "Moves an entire grid up"
(defn move-grid-up
  [grid]
  grid)
