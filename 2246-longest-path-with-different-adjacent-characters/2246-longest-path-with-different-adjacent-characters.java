class Solution {
    int ans = 1;
    public int pathLongest(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] tree = new ArrayList[n];
        for(int i=0; i<n; i++) tree[i] = new ArrayList<>();
        for(int i=1; i<n; i++) tree[parent[i]].add(i);

        dfs(0, tree, s);
        return ans;
    }

    private int dfs(int node, List<Integer>[] tree, String s) {
        int longest1 = 0, longest2 = 0;

        for(int child : tree[node]) {
            int childPath = dfs(child, tree, s);

            if(s.charAt(child) == s.charAt(node)) continue;

            if(childPath > longest1) {
                longest2 = longest1;
                longest1 = childPath;
            } else if(childPath > longest2) {
                longest2 = childPath;
            }
        }
        ans = Math.max(ans, 1+longest1+longest2);
        return 1+longest1;
    }
    public int longestPath(int[] parent, String s) {
        return pathLongest(parent, s);
    }
}