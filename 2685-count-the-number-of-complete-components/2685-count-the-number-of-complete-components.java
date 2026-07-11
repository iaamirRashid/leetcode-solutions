class Solution {
    public int completeGraph(int n, int[][] edges) {
         List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, graph, vis, comp);
                if (isComplete(comp, graph)) completeCount++;
            }
        }

        return completeCount;
    }

    void dfs(int node, List<List<Integer>> graph, boolean[] vis, List<Integer> comp) {
        vis[node] = true;
        comp.add(node);
        for (int neigh : graph.get(node)) {
            if (!vis[neigh]) dfs(neigh, graph, vis, comp);
        }
    }

    boolean isComplete(List<Integer> comp, List<List<Integer>> graph) {
        int k = comp.size();
        int totalEdges = 0;

        for (int node : comp) {
            for (int neigh : graph.get(node)) {
                if (comp.contains(neigh)) totalEdges++;
            }
        }

        totalEdges /= 2;
        return totalEdges == k * (k - 1) / 2;
   }

    public int countCompleteComponents(int n, int[][] edges) {
        return completeGraph(n, edges);
    }
}