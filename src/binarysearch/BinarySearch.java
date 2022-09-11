package binarysearch;

public class BinarySearch {
    
    public static void main(String[] args){
        int [] firstArray = new int []{2,5, 8, 9, 10, 20, 70, 90};
        int[] secondArray = new int []{100, 95, 90, 87, 75, 44, 32, 11};

        System.out.println("The result of BinarySearch --- "+ binarySearch(firstArray, 70));

        System.out.println("The result of Order-Agnostic BinarySearch --- "+ orderAgnosticBinarySearch(secondArray, 90));

    }

    //Assuming Array is Sorted in Ascending Order
    public static int binarySearch(int elements[], int target){
        int start = 0;
        int end = elements.length-1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(elements[mid] > target){
                end = mid - 1;
            } else if( elements[mid] < target){
                start = mid + 1;
            } else{
                return mid;
            }
        }

        return -1;
    }

    //If we don't know the Order of Sorting, this is called Order Agnostic Binary Search
    //First we need to first the sorting order than we apply the Binary Search accordingly
    public static int orderAgnosticBinarySearch(int ele[], int target){
        
        int start = 0, end = ele.length-1;
        boolean isAsc;
        if(ele[start] < ele[end]){
            isAsc = true;
        }else{
            isAsc = false;
        }
        
        while(start <= end){
            int mid = start + (end-start)/2;

            if(ele[mid] == target){
                return mid;
            } 
            else{
                if(isAsc){
                    if(ele[mid] > target){
                        end = mid - 1;
                    } else{
                        start = mid + 1;
                    }
                } else{
                    if(ele[mid] > target){
                        start = mid + 1;
                    } else{
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
