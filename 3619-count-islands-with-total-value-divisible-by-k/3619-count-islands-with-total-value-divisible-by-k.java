class Solution {
    public int islandCount(int[][] grid, int k) {
     int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !vis[i][j]) {
                    long sum = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    vis[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0], 
                        c = curr[1];
                        sum += grid[r][c];

                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];

    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] > 0 && !vis[nr][nc]) {
                                vis[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                    if (sum % k == 0) result++;
                }
            }
        }
        return result;
    }
    public int countIslands(int[][] grid, int k) {
        return islandCount(grid, k);
    }
}