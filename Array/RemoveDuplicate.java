import java.util.Arrays;
public class RemoveDuplicate{
     public static void main(String[] args) {
        int [] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("The original array is: "+Arrays.toString(nums));
        System.out.println("The length of the original array is: " + nums.length);

        int k = removeDuplicates(nums);
        System.out.println("The length of the array after removing duplicates is: " + k);

    }
    public static int removeDuplicates(int[] nums) {
         int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
    
}