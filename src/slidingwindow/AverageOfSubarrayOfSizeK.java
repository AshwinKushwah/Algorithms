package slidingwindow;

public class AverageOfSubarrayOfSizeK {
    public static void double[] findAverages(int K, int[] arr){
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

    }


    public static void main(String[] args){
        
    }



}
