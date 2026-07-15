class Solution {
    public int difficultyMin(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n<d) return -1;
        
        int dp[][] = new int[n+1][d+1];

        // initialize dp with INF
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        int maxDiff = 0;

       // Base case: when day = 1, all remaining jobs in one day
        int maxSoFar = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, jobDifficulty[i]);
            dp[i][1] = maxSoFar;
        }
        
        // Build DP for day = 2...d
        for (int day = 2; day <= d; day++) {
            for (int i = 0; i <= n - day; i++) { // must leave enough jobs for remaining days
                int max = 0;
                // try splitting at j
                for (int j = i; j <= n - day; j++) {
                    max = Math.max(max, jobDifficulty[j]);
                    dp[i][day] = Math.min(dp[i][day], max + dp[j + 1][day - 1]);
                }
            }
        }
        
        return dp[0][d];
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        return difficultyMin(jobDifficulty, d);
    }
}