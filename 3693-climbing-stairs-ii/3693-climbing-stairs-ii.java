class Solution {
    public int stare(int n, int[] costs) {
          int[] result = costs;
        int dp[] = new int[n+1];

        for(int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i=1; i<n+1; i++) {
            for(int jump = 1; jump<=3; jump++) {
                int prev = i - jump;
                if(prev >= 0) {
                    int cost = dp[prev] + result[i-1] + jump * jump;
                    dp[i] = Math.min(dp[i], cost);
                }
            }
        }
        return dp[n];
    }
    public int climbStairs(int n, int[] costs) {
     return stare(n, costs);   
    }
}