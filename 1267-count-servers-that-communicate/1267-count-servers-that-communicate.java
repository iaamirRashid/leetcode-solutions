class Solution {
    public int serversCount(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        // Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;

        // Count communicable servers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 &&
                    (row[i] > 1 || col[j] > 1)) {

                    ans++;
                }
            }
        }

        return ans;
    }
    public int countServers(int[][] grid) {
        return serversCount(grid);
    }
}