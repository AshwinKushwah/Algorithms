/** Problem Statement */

/**Given an array, find the average of all contiguous subarrays of size ‘K’ in it */

//Complexity - Time O(N) 


package slidingwindow;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int K, int[] arr){
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        //iterating through the array
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];

            //checking if we have K elements
            if(windowEnd >= K-1){
                result[windowStart] = windowSum / 5;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }


    public static void main(String[] args){
        double result [] = findAverages(5, new int[]{1,4,6,7,8,9,3,5,11});
        System.out.println("The result is--");
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }



}
