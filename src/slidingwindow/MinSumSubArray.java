/** Problem Statement */

/** Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous subarray whose sum is greater 
 * than or equal to ‘S’. Return 0, if no such subarray exists. */

 //Complexity - Time = O(N) , Space - O(1)

package slidingwindow;

public class MinSumSubArray {
    
    public static int minSumSubArrayofSum(int S, int[] elements){
        int minLength = elements.length+1 , windowStart = 0, windowSum = 0;

        for(int windowEnd = 0; windowEnd < elements.length; windowEnd++){
            System.out.println("Outer WindowEnd = " + windowEnd);
            windowSum += elements[windowEnd];

            while(windowSum >= S){
                minLength = Math.min(windowEnd-windowStart+1, minLength);
                windowSum -= elements[windowStart];
                windowStart++;
                System.out.println("inner  --" + " End = "+ windowEnd + " ,Start = "+ windowStart + ",  Sum == " + windowSum);

            }
        }

        return minLength == elements.length+1 ? 0 : minLength ;
    }
    
    public static void main(String[] args){
        System.out.println("The smallest sum = " + minSumSubArrayofSum(7, new int[]{0,0,0,0,0,10}));
        System.out.println("The smallest sum = " + minSumSubArrayofSum(7, new int[]{2,1,5,2,3,2}));
        System.out.println("The smallest sum = " + minSumSubArrayofSum(7, new int[]{2,1,5,2,8}));
        System.out.println("The smallest sum = " + minSumSubArrayofSum(8, new int[]{3,4,1,1,6}));
    }

}
