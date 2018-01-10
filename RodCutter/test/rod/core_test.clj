(ns rod.core-test
  (:require [clojure.test :refer :all]
            [rod.core :refer :all]))

(deftest a-test
  (testing "Canary"
    (is true))) 
    
(deftest testLength0
  (testing "first example"
    (def length 0)
    (def prices [[1][2][3][2]]) 
    (def cache (assoc (into []  (replicate (inc length) [0] ) )0 [0]))
    (def value(maxPrice prices length cache))
    (is (= [0[]] value)))) 

(deftest testLength1
  (testing "second example"
    (def length 1)
    (def prices [[1][2][3][2]])
    (def cache (assoc (into []  (replicate (inc length) [0] ) )0 [0]))
    (def value(maxPrice prices length cache))
    (is (= [1 [1]] value)))) 

(deftest testLength2
  (testing "third example"
    (def length 2)
    (def prices [[1][2][3][2]])
    (def cache (assoc (into []  (replicate (inc length) [0] ) )0 [0]))
    (def value(maxPrice prices length cache))
    (is (= [2 [2] [1 1]] value))))

(deftest testLength3
  (testing "fourth example"
    (def length 3)
    (def prices [[1][2][3][2]])
    (def cache (assoc (into []  (replicate (inc length) [0] ) )0 [0]))
    (def value(maxPrice prices length cache))
    (is (=  [3 [3] [1 2] [1 1 1]] value))))

(deftest testLength4
  (testing "fifth example"
    (def length 4)
    (def prices [[1][2][3][2]])
    (def cache (assoc (into []  (replicate (inc length) [0] ) )0 [0]))
    (def value(maxPrice prices length cache))
    (is (= [4 [1 1 1 1] [1 3] [1 1 2] [2 2]] value))))  
    
    
(deftest testLength17
  (testing "test length 17"
    (def length 17)
    (def prices [[1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [11] [12] [13] [14] [15] [16] [17]])
    (def cache (assoc (into []  (replicate (inc length) [0] ) )0 [0]))
    (def value(maxPrice prices length cache))
    (is (= 17 (nth value 0))) 
    (is (= 297 (-(count value)1))))) 
