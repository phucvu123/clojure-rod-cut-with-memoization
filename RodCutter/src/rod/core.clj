(ns rod.core)

                                                             
(defn maxPrice                                                           
  [price length cache]
   
  (if(= (nth(nth cache length)0) 0)
    ( 
    if(= length 0) 
       [0[]]
       (do
            (loop [iter 1
                   temp-cache  cache]
                (if (> iter length)
                    (nth temp-cache length)
                       
                    (recur (inc iter)(assoc temp-cache iter (do   
                       (def zeros (replicate (- iter (count price)) [0] ))
                       (def priceList (into [](concat price zeros)))
                       (def subPrice (subvec priceList 0 iter)) 
                       (def vect (map-indexed (fn [index value](do 
                            (def returnVec (maxPrice price (- iter index 1)  temp-cache))(assoc returnVec 0 (+ (nth value 0) (nth returnVec 0))))) subPrice ))                                     
                       (def max-value (apply max (map (fn[value](do (nth value 0))) vect)))
                       (def cuts-with-max-filtered (into [](filter (fn [value] (= (nth value 0) max-value)) vect )))                                                                
                                                     
                       (def add-cuts  (into[](map-indexed (fn [index value](do                                                 
                           (def cut (into[] value))                                          
                           (def cut-after-added-length (map-indexed (fn [index2 val](do                       
                                (if(= index2 0)                                        
                                  (do val)                     
                                  (do (def add-length-cut (conj val (inc index)))(into[](sort add-length-cut))))))cut ))(into []cut-after-added-length) )) cuts-with-max-filtered)))                   
                       (def remove-duplicate   (into [](set (reduce concat (into[](map (fn[value](into[](drop 1 value)))add-cuts))))))                                      
                       (conj(assoc remove-duplicate 0 max-value)(nth remove-duplicate 0)))))))))                                   
        (nth cache length)))   
                                       
                                    
                                    
                                
           
              
            
            
         
        
       
       
      
      
  
  
  
       