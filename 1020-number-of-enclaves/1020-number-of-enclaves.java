class Solution {
     int m, n;

    public int numbEnclaves(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        // Boundary rows
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1)
                dfs(grid, 0, j);

            if (grid[m - 1][j] == 1)
                dfs(grid, m - 1, j);
        }

        // Boundary columns
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                dfs(grid, i, 0);

            if (grid[i][n - 1] == 1)
                dfs(grid, i, n - 1);
        }

        // Count remaining 1s
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int i, int j) {

        // Out of boundary
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        // Sea or already visited
        if (grid[i][j] == 0) {
            return;
        }

        // Mark visited
        grid[i][j] = 0;

        // Up
        dfs(grid, i - 1, j);

        // Down
        dfs(grid, i + 1, j);

        // Left
        dfs(grid, i, j - 1);

        // Right
        dfs(grid, i, j + 1);
    }
    public int numEnclaves(int[][] grid) {
     return numbEnclaves(grid);
    }
}