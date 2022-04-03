//Problem Statement - String Anagrams

/** Given a string and a pattern, find all anagrams of the pattern in the given string. 
 * Anagram is actually a Permutation of a string.
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
*/

 //Time Complexity - O(N+M) , N & M are characters in String and Pattern respectively
 //Space Complexity - O(M)

package slidingwindow;

import java.util.*;

public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern){
        List<Integer> resultIndices = new ArrayList<Integer>();
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();


        for(char c : pattern.toCharArray()){
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0)+1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(charFreqMap.containsKey(rightChar)){
                charFreqMap.put(rightChar, charFreqMap.get(rightChar)-1);

            if(charFreqMap.get(rightChar) == 0)
                matched++;
            }
            if(matched == charFreqMap.size()){
                resultIndices.add(windowStart);
            }
            
            if(windowEnd >= pattern.length()-1){
                char leftChar = str.charAt(windowStart);

                if(charFreqMap.containsKey(leftChar)){
                    if(charFreqMap.get(leftChar) == 0)
                        matched--;
                    
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar)+1);
                }
                windowStart++;
            }
            
                
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println("The Anagrams indices are -- "+ findStringAnagrams("ppqp", "pq"));
        System.out.println("The Anagrams indices are -- "+ findStringAnagrams("abbcabc", "abc"));
        System.out.println("The Anagrams indices are -- "+ findStringAnagrams("cbaebabacd", "abc"));
        System.out.println("The Anagrams indices are -- "+ findStringAnagrams("abab", "ab"));

    }
}
