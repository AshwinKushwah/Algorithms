package binarysearch;

import java.util.Arrays;

public class FirstLastPosition {
    
    public static void main(String [] args){
        System.out.println("inside main");
        int[] elements = new int[]{5, 7,7,7,7,7,8,9,10};
        int target = 7;
        System.out.println("The First and Last Occurance of target: "+target+", is = "+Arrays.toString(searchRange(elements,target)));
    }

    public static int [] searchRange(int [] elements, int target){
        int start = 0, end = elements.length-1;
        int startIndex = Integer.MAX_VALUE;
        int endIndex = -1;
        //apply bineary search to find the first Occurance
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(elements[mid] > target){
                end = mid - 1;
            } else if(elements[mid] < target){
                start = mid + 1;
            } else{
                startIndex = Math.min(startIndex, mid);
                end = mid - 1;
            }
        }
        //reset the start and end 
        start = 0;
        end = elements.length - 1;
        //apply binary search to find the last occurance
        while(start <= end){
            int mid = start + (end - start)/2;
            if(elements[mid] > target){
                end = mid - 1;
            } else if(elements[mid] < target){
                start = mid + 1;
            } else{
                endIndex = Math.max(endIndex, mid);
                start = mid + 1;
            }
        }
        if(endIndex != -1 && startIndex !=  Integer.MAX_VALUE){
            return new int[]{startIndex, endIndex};
        } else{
            return new int[]{-1, -1};
        }
        
    }
}
