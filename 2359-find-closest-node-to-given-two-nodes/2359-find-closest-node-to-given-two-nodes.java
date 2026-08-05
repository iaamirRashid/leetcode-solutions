class Solution {
    public int meetingNode(int[] edges, int node1, int node2) {
           int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        // DFS from node1 and node2
        dfs(node1, 0, edges, dist1, visited1);
        dfs(node2, 0, edges, dist2, visited2);

        int ans = -1;
        int minDist = Integer.MAX_VALUE;

        // Compare all nodes
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxD = Math.max(dist1[i], dist2[i]);
                if (maxD < minDist) {
                    minDist = maxD;
                    ans = i;
                } else if (maxD == minDist && i < ans) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    private void dfs(int node, int dist, int[] edges, int[] distance, boolean[] visited) {
        if (node == -1 || visited[node]) return;

        visited[node] = true;
        distance[node] = dist;

        dfs(edges[node], dist + 1, edges, distance, visited);
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        return meetingNode(edges, node1, node2);
    }
}