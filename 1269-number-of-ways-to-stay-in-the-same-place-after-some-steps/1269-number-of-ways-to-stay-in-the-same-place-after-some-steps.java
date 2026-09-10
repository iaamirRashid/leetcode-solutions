class Solution {
    public int waysNum(int steps, int arrLen) {

         int MOD = 1000000007;

        // It is never useful to go beyond steps positions
        int len = Math.min(arrLen, steps + 1);

        int[][] dp = new int[steps + 1][len];

        // 0 steps, index 0
        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {

            for (int j = 0; j < len; j++) {

                // Stay
                dp[i][j] = dp[i - 1][j];

                // Come from left
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= MOD;
                }

                // Come from right
                if (j + 1 < len) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[steps][0];
    }
    public int numWays(int steps, int arrLen) {
        return waysNum(steps, arrLen);
    }
}