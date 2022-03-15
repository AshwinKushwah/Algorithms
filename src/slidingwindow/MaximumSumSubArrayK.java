/** Problem Statement */

/*Given an array of positive numbers and a positive number ‘k’,
 find the maximum sum of any contiguous subarray of size ‘k’ */

 //Complexity - Time O(N) , Space O(1)


package slidingwindow;

public class MaximumSumSubArrayK {
   public static Integer maximumSumSubArray(int K,int [] elements){
       int maxSum = 0 , windowStart = 0 ;
       int subArraySum = 0;
       for(int windowEnd = 0; windowEnd < elements.length; windowEnd++){
             subArraySum += elements[windowEnd];

             if(windowEnd >= K-1){
                maxSum = Math.max(subArraySum, maxSum);
                subArraySum -= elements[windowStart];
                windowStart++;
             }

       }

       return maxSum;
   }

   public static void main(String [] args){
       System.out.println("Maximum Sum of SubArray = " +
        maximumSumSubArray(3, new int[]{2,1,5,1,3,2}) );

        System.out.println("Maximum Sum of SubArray = " +
        maximumSumSubArray(2, new int[]{2,3,4,1,5}) );
        
   }
}
