// Maximum Alternating Sum of Squares 
import java.util.Arrays;

public class AlternateSquare{
    public static void main(String[] args ){
        Solution solution = new Solution();
        int[] nums = {4, 2, 5, 3};
        long result = solution.maxAlternatingSum(nums);
        System.out.println("Maximum Alternating Sum of Squares: " + result);
    }
}
class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);

        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long score = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                score -= squares[i];
            } else {
                score += squares[i];
            }
        }

        return score;
    }
}