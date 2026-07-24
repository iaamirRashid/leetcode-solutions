class Solution {
    public List<List<Integer>> pathSourceToTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, graph.length-1, res, path);
        return res;
    }
    public void dfs(int[][] graph, int source, int target, List<List<Integer>> res, List<Integer> path) {
        if(source == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int neigh : graph[source]) {
            path.add(neigh);
            dfs(graph, neigh, target, res, path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      return pathSourceToTarget(graph);
    }
}