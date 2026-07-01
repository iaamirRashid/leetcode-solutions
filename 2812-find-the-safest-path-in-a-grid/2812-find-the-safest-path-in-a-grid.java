class Solution {
    public int safenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        // Multi Source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Max Heap
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[2] - a[2]);

        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int safe = cur[2];

            if (vis[r][c]) continue;
            vis[r][c] = true;

            if (r == n - 1 && c == n - 1) {
                return safe;
            }

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {

                    int newSafe = Math.min(safe, dist[nr][nc]);

                    pq.offer(new int[]{nr, nc, newSafe});
                }
            }
        }

        return 0;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        return safenessFactor(grid);
    }
}