class Solution {
    public int droneDistance(int[][] drones, int[] target) {
        int ans = -1;
        int minDistance = Integer.MAX_VALUE;

        int tx = target[0];
        int ty = target[1];

        for(int i=0; i<drones.length; i++) {
              int xi = drones[i][0];
              int yi = drones[i][1];
              int range = drones[i][2];

              int distance = Math.abs(xi-tx) + Math.abs(yi - ty);

              if(distance <= range && distance < minDistance) {
                minDistance = distance;
                ans = i;
              }
        }
        return ans;
    }
    public int nearestDrone(int[][] drones, int[] target) {
        return droneDistance(drones, target);
    }
}