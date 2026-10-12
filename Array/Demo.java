import java.util.List;
class Demo {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bits = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 31; j >= 0; j--) {
                if (bits[j] > 0) {
                    num |= (1L << j);
                    bits[j]--;
                }
            }

            ans = (ans + num * num) % MOD;
        }

        return (int) ans;
    }
}