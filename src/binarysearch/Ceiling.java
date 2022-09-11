
/* Problem Statement - Find the Ceiling of the Number
 * Ceiling - The Smallest number which is greater than or equal to the number
 *  Link -- https://leetcode.com/problems/search-insert-position/
 */
 /**
  * Time Complexity - O(logN)
  */

package binarysearch;

public class Ceiling {
    
    public static void main(String[] args){
        int[] elements = new int []{2,5, 8, 9, 10, 20, 70, 90};

        System.out.println("The result of BinarySearch --- "+ findCeiling(elements, 11));

    }

    public static int findCeiling(int [] ele, int target){
        int start = 0, end = ele.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(ele[mid] > target){
                end = mid - 1;
            } else if(ele[mid] < target){
                start = mid + 1;
            } else{
                return mid;
            }
        }

        return start;
    }
}
