class Solution {
   public boolean dfs(int curr, int destination, List<List<Integer>> graph, boolean[] vis) {
        if (curr == destination) return true;
        vis[curr] = true;

        for (int neigh : graph.get(curr)) {
            if (!vis[neigh]) {
                if (dfs(neigh, destination, graph, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // because undirected
        }

        boolean[] vis = new boolean[n];
        return dfs(source, destination, graph, vis);
    }
}