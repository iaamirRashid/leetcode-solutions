class Solution {

    public static int coinchange(int coins[], int amount) {
        int n = coins.length;
        int m = amount;

        int dp[][] = new int[n+1][m+1];
        
        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<m+1; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }


        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(coins[i-1]<=j) {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m] == Integer.MAX_VALUE - 1 ? -1 : dp[n][m];
}
    

    //  public static int change(int[] coins, int amount) {
    //     // Initialize the dp array with a large value (infinity equivalent)
    //     int[] dp = new int[amount + 1];
    //     Arrays.fill(dp, amount + 1); // Use amount + 1 as "infinity"
    //     dp[0] = 0; // Base case: 0 coins needed to make amount 0

    //     // Fill the dp array iteratively
    //     for (int i = 1; i <= amount; i++) {
    //         for (int coin : coins) {
    //             if (i >= coin) {
    //                 dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    //             }
    //         }
    //     }

    //     // If dp[amount] is still the "infinity" value, return -1
    //     return dp[amount] > amount ? -1 : dp[amount];
    // }

    public int coinChange(int[] coins, int amount) {
        return coinchange(coins, amount);
     
    }
}