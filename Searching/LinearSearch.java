package Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        int result = linearSearch(arr, target);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    public static int linearSearch(int[] nums,int target){

        for(int i =0; i<nums.length; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
