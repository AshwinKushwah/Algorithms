//Problem Statement - Permutation in a String

/** Given a string and a pattern, find out if the string
 *  contains any permutation of the pattern */

 //Time Complexity - O(N+M) , N & M are characters in String and Pattern respectively
 //Space Complexity - O(M)

package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    
    public static boolean checkPermutation(String str, String pattern){
        int windowStart = 0, matched = 0;
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        for(char c : pattern.toCharArray()){
            patternFreqMap.put(c, patternFreqMap.getOrDefault(c, 0)+1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(patternFreqMap.containsKey(rightChar)){
                patternFreqMap.put(rightChar, patternFreqMap.get(rightChar)-1);
                
                if(patternFreqMap.get(rightChar) == 0)
                    matched++;
            }
            if(matched == patternFreqMap.size())
                return true;
            
            if(windowEnd >= pattern.length()-1){
                char leftChar = str.charAt(windowStart);
                if(patternFreqMap.containsKey(leftChar)){
                    if(patternFreqMap.get(leftChar) == 0)
                        matched--;
                    patternFreqMap.put(leftChar, patternFreqMap.get(leftChar)+1);    
                }
                windowStart++;
            }
            
        }

        return false;
        
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("odicf", "dc"));
        System.out.println(checkPermutation("abcdxabcde", "abcdeabcdx"));
    }
}
