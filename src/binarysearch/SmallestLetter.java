/** Problem Statement - Given a characters array letters that is sorted in non-decreasing order and a character target, 
 * return the smallest character in the array that is larger than target.
Note that the letters wrap around.
For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 * 
 * Link - https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 * Time Complexity - O(logN)
 */

package binarysearch;

public class SmallestLetter {
    
    public static void main(String arsg[]){
        char [] letters = new char []{'c','f','j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char [] letters, char target){

        int start = 0, end = letters.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(letters[mid] > target){
                end = mid - 1;
            } 
            //on equal condition the start increment should be considered
            //if equal condition is considered in end decrement result would be wrong
            else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];

    } 
}
