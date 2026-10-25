class Solution {
    public int islandClosed(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0 && !vis[i][j]) {
                    if (isClosed(i, j, grid, vis, dir))
                        count++;
                }
            }
        }
        return count;
    }

    private boolean isClosed(int i, int j, int[][] grid, boolean[][] vis, int[][] dir) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        vis[i][j] = true;

        boolean isClosed = true; // assume closed

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            // if land touches boundary → NOT closed
            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                isClosed = false;
            }

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (grid[nx][ny] == 0 && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return isClosed;
    }

    public int closedIsland(int[][] grid) {
        return islandClosed(grid);
    }
}