class Solution {
    public int costMin(int[][] grid) {
          int m = grid.length, n = grid[0].length;
        final int MAX = 1024; // values < 1024 => XOR bhi < 1024

        // dp[j][x] = true agar current row ke column j tak XOR = x possible hai
        boolean[][] dp = new boolean[n][MAX];
        dp[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int v = grid[i][j];
                boolean[] cur = new boolean[MAX];

                // upar se aane wali values (dp[j] abhi pichli row ki hai)
                if (i > 0) {
                    for (int x = 0; x < MAX; x++) {
                        if (dp[j][x]) cur[x ^ v] = true;
                    }
                }
                // left se aane wali values (dp[j-1] abhi current row ki hai)
                if (j > 0) {
                    for (int x = 0; x < MAX; x++) {
                        if (dp[j - 1][x]) cur[x ^ v] = true;
                    }
                }
                dp[j] = cur;
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (dp[n - 1][x]) return x;
        }
        return -1;
    }
    public int minCost(int[][] grid) {
        return costMin(grid);
    }
}