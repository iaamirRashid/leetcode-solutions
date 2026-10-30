class Solution {
    public int pathShortest(int n, int[][] edges, String labels, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph.get(u).add(new int[]{v, w});
        }

        long INF = Long.MAX_VALUE;

        // dist[node][streak]
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        // {distance, node, streak}
        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long d = cur[0];
            int u = (int) cur[1];
            int streak = (int) cur[2];

            if (d != dist[u][streak]) continue;

            if (u == n - 1) return (int) d;

            for (int[] nei : graph.get(u)) {

                int v = nei[0];
                int w = nei[1];

                int newStreak;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newStreak = streak + 1;
                } else {
                    newStreak = 1;
                }

                if (newStreak > k) continue;

                long newDist = d + w;

                if (newDist < dist[v][newStreak]) {

                    dist[v][newStreak] = newDist;
                    pq.offer(new long[]{newDist, v, newStreak});
                }
            }
        }

        return -1;

        
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        return pathShortest(n, edges, labels, k);
    }
}