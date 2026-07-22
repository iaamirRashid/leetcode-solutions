class Solution {
    public boolean visitAllRooms(List<List<Integer>> rooms) {
       int n = rooms.size();
        boolean[] vis = new boolean[n];

        // Start from room 0
        dfs(rooms, 0, vis);

        // Check if all rooms are visited
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int src, boolean[] vis) {
        vis[src] = true;
        for (int neigh : rooms.get(src)) {
            if (!vis[neigh]) {
                dfs(rooms, neigh, vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        return visitAllRooms(rooms);
    }
}