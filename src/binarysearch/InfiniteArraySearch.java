/** Problem Statement - Suppose you have a sorted array of infinite numbers, 
 * how would you search an element in the array?
 * 
 * Link - https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 *
 * Time Complexity - O(logN) 
 */



package binarysearch;

public class InfiniteArraySearch {
    
    public static void main(String[] args){
        int [] elements = new int [] {10, 11, 13, 18, 19, 20, 24, 60, 76, 90, 100, 105, 110, 203, 340, 405};
        int target = 24; 
        System.out.println("The result of search in Infinite Array is --"+ findAnswer(elements, target));
    }

    public static int findAnswer(int[] elements, int target){
        //first we need to find the range where the target element can appear
        //by moving in chunks
        //Initally taking the size as 2 , each time we double the size
        int start = 0;
        int end = 1;
        while(elements[end] < target){
            int tempStart = end + 1;
            //double the window size
            //end = end + size of window * 2
            end = end + (end - start + 1)*2;
            start = tempStart;
        }
        System.out.println("start--"+ start+", end=="+ end);
        //apply the binary search on the window where target will be present
        return binarySearch(elements, target, start, end);
    }
    static int binarySearch(int elements[], int target, int start, int end){
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(elements[mid] > target){
                end = mid - 1;
            } else if(elements[mid] < target){
                start = mid + 1;
            } else{
                return mid;
            }
        }

        return -1;
    }
}
