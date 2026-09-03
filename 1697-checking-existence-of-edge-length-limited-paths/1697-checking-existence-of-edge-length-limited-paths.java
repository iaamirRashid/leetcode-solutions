class Solution {
   public boolean[] limitDistancePath(int n, int[][] edgeList, int[][] queries) {
        int q = queries.length;
        boolean[] ans = new boolean[q];

        // queries ko index ke sath store karo
        int[][] queriesWithIndex = new int[q][4];
        for (int i = 0; i < q; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i; // original index
        }

        // sort queries by limit
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[2]));

        // sort edges by weight
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        DSU dsu = new DSU(n);
        int edgeIndex = 0;

        // process queries in increasing limit order
        for (int[] query : queriesWithIndex) {
            int u = query[0], v = query[1], limit = query[2], idx = query[3];

            // add all edges with weight < limit
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                dsu.union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }

            // check connectivity
            ans[idx] = (dsu.find(u) == dsu.find(v));
        }

        return ans;
    }

    // DSU as inner static class
    private static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        return limitDistancePath(n, edgeList, queries);
    }
}