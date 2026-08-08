class Solution {
    public int scoreMin(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
         boolean vis[] = new boolean[n+1];
        // int dis[] = new int[n];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int[] e : roads) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            graph.get(u).add(new int[]{v , wt});
            graph.get(v).add(new int[]{u, wt});
        }

        Queue<Integer> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        
        q.add(1);
        vis[1] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int[] neigh : graph.get(curr)) {
                int v = neigh[0], w = neigh[1];
                ans = Math.min(ans, w);
                if(!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }

            }
        }
        return ans;
    }
    public int minScore(int n, int[][] roads) {
        return scoreMin(n, roads);
    }
}