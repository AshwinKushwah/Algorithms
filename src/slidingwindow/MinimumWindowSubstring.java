//Problem Statement - Minimum Window Substring
/** Given a string and a pattern, return the minimum window substring
 * of string, such that every character of pattern (including duplicates) is included
 * in the window.
 * If there is no such substring, return the empty string "".
 */

 //Time Complexity - O(N+M) , N & M are characters in String and Pattern respectively
 //Space Complexity - O(M) +  O(N) 

package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    
    public static String findSubString(String str, String pattern){
        int windowStart = 0, matched = 0, minLength = str.length()+1, subStrStart = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(char c: pattern.toCharArray()){
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0)+1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(charFreqMap.containsKey(rightChar)){
                charFreqMap.put(rightChar, charFreqMap.get(rightChar)-1);

                if(charFreqMap.get(rightChar) >= 0)
                    matched++;
            }
            while(matched == pattern.length()){
                if(minLength > windowEnd - windowStart + 1){
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }
                char leftChar = str.charAt(windowStart);
                if(charFreqMap.containsKey(leftChar)){
                   
                    if(charFreqMap.get(leftChar) == 0)
                        matched--;
                   charFreqMap.put(leftChar, charFreqMap.get(leftChar)+1);
                }
                windowStart++;



            }
        }


        return minLength > str.length() ? "" : str.substring(subStrStart , subStrStart + minLength);
        
    }

    public static void main(String [] args){
        System.out.println("minimun substring ---" + findSubString("aabdec", "abc"));
        System.out.println("minimun substring ---" + findSubString("ADOBECODEBANC", "ABC"));
        System.out.println("minimun substring ---" + findSubString("a", "a"));
        System.out.println("minimun substring ---" + findSubString("a", "aa"));
        
    }
}
