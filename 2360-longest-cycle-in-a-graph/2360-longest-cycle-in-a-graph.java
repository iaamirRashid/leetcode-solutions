class Solution {
    public int longestCycles(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        boolean[] inPath = new boolean[n];
        int[] time = new int[n];

        int[] timer = new int[1];   // wrapper for pass-by-reference
        timer[0] = 1;

        int[] ans = new int[1];
        ans[0] = -1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, edges, visited, inPath, time, timer, ans);
            }
        }
        return ans[0];
    }

    private void dfs(
        int node,
        int[] edges,
        boolean[] visited,
        boolean[] inPath,
        int[] time,
        int[] timer,
        int[] ans
    ) {
        visited[node] = true;
        inPath[node] = true;
        time[node] = timer[0]++;

        int next = edges[node];
        if (next != -1) {
            if (!visited[next]) {
                dfs(next, edges, visited, inPath, time, timer, ans);
            } else if (inPath[next]) {
                ans[0] = Math.max(ans[0], time[node] - time[next] + 1);
            }
        }

        inPath[node] = false; // backtrack
    }
    public int longestCycle(int[] edges) {
        return longestCycles(edges);
    }
}