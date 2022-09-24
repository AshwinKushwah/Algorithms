//Problem Statement - Peak Index in Mountain Array
/**
 * An array arr a mountain if the following properties hold:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 * Link - https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

//Time Complexity - O(logn)

package binarysearch;

public class PeakInMountainArray {
   public static void main(String[] args){

   }
   
   public static int findPeakApproachOne(int arr[]){
    int start = 0, end = arr.length-1;

    while(start < end){
        int mid = start + (end - start)/2;

        if(arr[mid] > arr[mid+1]){
            //we are in decreasing part of array
            //this may be the ans, but we will check left
            //that's why end != mid - 1
            end = mid;
        } else{
            //we are in increasing part of the array
            start = mid + 1;
        }
    }
    //In the end, start == end and point to the largest element in array
    //start and end are always trying to find the max element in above conditions
    //hence, when they are pointing to one element, that is max.
    //At Every point of time for start and end, they have best possible answer till that time
    //and if only one element is remaining, so that will be the best possible answer
    return start; //  or return end they both point to same location.
   }
}
