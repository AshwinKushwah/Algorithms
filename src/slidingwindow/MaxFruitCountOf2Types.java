//Problem Statement

/**Given an array of characters where each character represents a fruit tree, you are given two baskets 
 * and your goal is to put maximum number of fruits in each basket. 
 * The only restriction is that each basket can have only one type of fruit.
 * 
 * You can start with any tree, but once you have started you can’t skip a tree.
 *  You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * 
 */

 // Time Complexity - O(N+N) = O(N)
 // Space Complexity - O(1) = There can be maximum of three type of fruits stored in charFrequencyMap
 


package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findMaxFruitSubArrayLength(char [] fruits){
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++){
            
            charFrequencyMap.put(fruits[windowEnd], charFrequencyMap.getOrDefault(fruits[windowEnd], 0)+1);
            while(charFrequencyMap.size() > 2){
                charFrequencyMap.put(fruits[windowStart],charFrequencyMap.get(fruits[windowStart])-1);

                if(charFrequencyMap.get(fruits[windowStart]) == 0){
                    charFrequencyMap.remove(fruits[windowStart]);
                }

                windowStart++;

            }

            maxLength = Math.max(maxLength, (windowEnd-windowStart)+1);
        }
        return maxLength;
    }

     public static void main(String[] args) {
        System.out.println("Maximum Number of Fruits : "+ 
                             findMaxFruitSubArrayLength(new char[]{'A', 'B', 'C', 'A', 'C'}));  
    
         System.out.println("Maximum Number of Fruits : "+ 
                             findMaxFruitSubArrayLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));  
    }
        
}
