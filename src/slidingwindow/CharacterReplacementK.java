// Problem Statement 

/** Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement. */

//Time Complexity - O(N)
//Space Complexity - O(26) -- O(1)

package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacementK {

    public static int findMaxLengthRepeatKSubs(String s, int K){ 
        int windowStart = 0, maxLength = 0, maxCharcterCount = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char rightChar = s.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0)+1);
            maxCharcterCount = Math.max(maxCharcterCount, charFrequency.get(rightChar));

            if((windowEnd - windowStart + 1) - maxCharcterCount > K){
                char leftChar = s.charAt(windowStart);
                charFrequency.put(leftChar, charFrequency.get(leftChar)-1);
                windowStart++;

            }

            maxLength = Math.max(windowEnd - windowStart + 1 , maxLength);

        }
        return maxLength;
    }

     public static void main(String[] args) {
       System.out.println("Maximum Length String With Same Letter - " + findMaxLengthRepeatKSubs("aabccbb", 2));
       System.out.println("Maximum Length String With Same Letter - " + findMaxLengthRepeatKSubs("abbcb", 1));
       System.out.println("Maximum Length String With Same Letter - " + findMaxLengthRepeatKSubs("abccde", 1));
 
    }
    
}
