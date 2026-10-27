class Solution {
    public String[] gridCreate(int m, int n) {
        char[][] grid = new char[m][n];

        // Fill with obstacles
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        // First row free
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        // Last column free
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
    public String[] createGrid(int m, int n) {
        return gridCreate(m,n);
    }
}