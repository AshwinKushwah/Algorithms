/** Problem Statement */

/** Given a string, find the length of the longest substring in it with,
 *  no more than K distinct characters. */

// Complexity - Time - O(N+N) => O(N)
//              Space - O(K)  => HashMap Characters               


package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    
    public static Integer findLength(String str, int k){
        if(str == null || str.length() == 0 || str.length() < k){
            throw new IllegalArgumentException();
        }
        int windowStart = 0 , maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        
        for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 1)+1);

            if(charFrequencyMap.size()>k){
                
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)-1);
                if(charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, (windowEnd-windowStart)+1);
        }


        return maxLength;
    }


    public static void main(String args[]){
        System.out.println("The max lenght with k distinct char = " + findLength("araaci", 2));
        System.out.println("The max lenght with k distinct char = " + findLength("araaci", 1));
        System.out.println("The max lenght with k distinct char = " + findLength("cbbebi", 3));

    }
}