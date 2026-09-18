package Searching;

public class LinearSearchUsingRecursion {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        int i=0;
        int result = linearSearch(arr, target,i);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    public static int linearSearch(int[] nums, int target,int i){
        
        if(i>nums.length){
            return -1;
        }
         if(nums[i]==target){
            return i;
        }
       
            return linearSearch(nums, target, i+1);
        
    }
}
