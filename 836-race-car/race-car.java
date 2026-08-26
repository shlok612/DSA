class Solution {
    public int racecar(int target) {

        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {

            // Number of A's needed to reach or pass i
            int n = 32 - Integer.numberOfLeadingZeros(i);

            // Exactly reach i:
            // 2^n - 1 = i
            if ((1 << n) - 1 == i) {
                dp[i] = n;
                continue;
            }

            // Case 1:
            // Go past i, reverse, then solve the remaining distance
            dp[i] = n + 1 + dp[(1 << n) - 1 - i];

            // Case 2:
            // Stop before reaching i, reverse,
            // move backwards some distance, reverse again
            for (int j = 0; j < n - 1; j++) {

                int forward = (1 << (n - 1)) - 1;
                int backward = (1 << j) - 1;

                int remaining = i - forward + backward;

                dp[i] = Math.min(
                    dp[i],
                    (n - 1) + 1 + j + 1 + dp[remaining]
                );
            }
        }

        return dp[target];
    }
}