class Solution {
    public boolean bipartitionPossible(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : dislikes) {
            int u = e[0]-1;
            int v = e[1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int col[] = new int[n];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(col[i] == -1) {
                q.add(i);
                col[i] = 0;

                while(!q.isEmpty()) {
                    int curr = q.poll();
                    for(int neigh : graph.get(curr)) {
                        if(col[neigh] == -1) {
                            col[neigh] = col[curr] ^ 1;
                            q.add(neigh);
                        } else if (col[neigh] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        return bipartitionPossible(n, dislikes);
    }
}