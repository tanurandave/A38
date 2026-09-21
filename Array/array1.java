class array1 {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] newDp = new long[k];

            int remainder = num % k;

            // Start a new subarray with the current number
            newDp[remainder] = 1;

            // Extend previous subarrays
            for (int i = 0; i < k; i++) {
                int newRemainder = (int) ((long) i * remainder % k);

                newDp[newRemainder] += dp[i];
            }

            // Add current counts to the final result
            for (int i = 0; i < k; i++) {
                result[i] += newDp[i];
            }

            dp = newDp;
        }

        return result;
    }
}