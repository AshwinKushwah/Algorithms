//Problem Statement - Longest Substarray with Ones after Replacement (Max consecutive Ones after replacement)

/** Given an array A of 0's and 1's, and a value K which indicates that 
 * you may change up to K values from 0 to 1. 
 * Return the length of the longest (contiguous) subarray that contains only 1’s. */

//Time Complexity - O(N)
//Space Complexity - O(1)
 
package slidingwindow;

public class LongestSubarrayWithOnesAfterReplacement {
    
    public static int findMaxConsecutiveOnes(int [] elements, int K){

        int windowStart = 0, maxLength = 0, onesCount = 0;

        for(int windowEnd = 0; windowEnd < elements.length;  windowEnd++){
            if(elements[windowEnd] == 1)
                onesCount++;
             
            if(windowEnd - windowStart + 1 - onesCount > K){
                if(elements[windowStart] == 1)
                    onesCount--;

                windowStart++;
                
            }
            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);

        }

        return maxLength;
    }

    public static void main(String [] args){
        System.out.println("Max Length is -- " + findMaxConsecutiveOnes(new int [] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},
                                                3));
        System.out.println("Max Length is -- " + findMaxConsecutiveOnes(new int [] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));                                       
    }


}
