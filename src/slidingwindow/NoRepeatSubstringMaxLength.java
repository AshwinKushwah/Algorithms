//Problem Statement

/** Given a string, find the length of the longest substring which has no 
 * repeating characters.
*/

//Time Complexity - O(N)

//Space Complexity - O(K) , if expect only 26 English letter then O(1), we can use fixed-size array


package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstringMaxLength {
    public static int findMaxLength(String s){
        int windowStart = 0, maxLength = 0;
        Map<Character,Integer> charIndexMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < s.length() ; windowEnd++){
             char rightChar = s.charAt(windowEnd);
            if(charIndexMap.containsKey(rightChar)){
               
                int threshold = charIndexMap.get(rightChar);
                //In the current window, we will not have any 'rightChar' after its previous inde
                //and if 'windowStart' is already ahead of the last index of 'rightChar', we will keep 'windowStart'
                windowStart = Math.max(threshold+1, windowStart);
                
            }
            charIndexMap.put(rightChar, windowEnd);

            maxLength = Math.max((windowEnd-windowStart)+1, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("The Maximum Length is -- " + findMaxLength("aabccbb"));
        System.out.println("The Maximum Length is -- " + findMaxLength("abbbb"));
        System.out.println("The Maximum Length is -- " + findMaxLength("abccde")); 
        System.out.println("The Maximum Length is -- " + findMaxLength("abba"));
       
    }
}
