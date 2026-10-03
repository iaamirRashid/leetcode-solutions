class Solution {
    public int rottingOrange(int[][] grid) {

    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> q = new LinkedList<>();
    int fresh = 0;

    // Step 1: Add all rotten oranges to queue
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 2) {
                q.add(new int[]{i, j, 0});   // x, y, time
            } else if (grid[i][j] == 1) {
                fresh++;
            }
        }
    }

    if (fresh == 0) return 0;

    int time = 0;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    // Step 2: BFS
    while (!q.isEmpty()) {
        int[] curr = q.poll();
        int x = curr[0];
        int y = curr[1];
        int t = curr[2];

        time = Math.max(time, t);

        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                grid[nx][ny] = 2;  // rot this fresh orange
                fresh--;
                q.add(new int[]{nx, ny, t + 1});
            }
        }
    }
    return fresh == 0 ? time : -1;

    }
    public int orangesRotting(int[][] grid) {
        return rottingOrange(grid);
    }
}