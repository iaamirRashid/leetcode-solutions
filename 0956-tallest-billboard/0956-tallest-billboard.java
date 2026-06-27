class Solution {
    public int billboard(int[] rods) {
         int sum = 0;
        for (int x : rods) sum += x;

        int[] dp = new int[sum + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int rod : rods) {

            int[] cur = dp.clone();

            for (int diff = 0; diff <= sum; diff++) {

                if (cur[diff] == -1) continue;

                // Add to taller side
                dp[diff + rod] = Math.max(dp[diff + rod], cur[diff]);

                // Add to shorter side
                int newDiff = Math.abs(diff - rod);
                int newSmaller = cur[diff] + Math.min(diff, rod);

                dp[newDiff] = Math.max(dp[newDiff], newSmaller);
            }
        }

        return dp[0];
    }
    public int tallestBillboard(int[] rods) {
        return billboard(rods);
    }
}