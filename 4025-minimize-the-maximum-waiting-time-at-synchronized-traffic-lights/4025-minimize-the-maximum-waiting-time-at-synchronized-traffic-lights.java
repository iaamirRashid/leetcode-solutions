class Solution {
    public int penaltyMin(int period, int[] lights, int[] arrivalTime) {
    
        int maxLight = 0;

        for(int light : lights) {
            maxLight = Math.max(maxLight, light);
        }

        int maxWaitingTime = 0;

        for(int time : arrivalTime) {

            int r = time%period;

            if(r >= maxLight) {
                int waitingTime = period - r;

                maxWaitingTime = Math.max(maxWaitingTime, waitingTime);
            }
        }
        return maxWaitingTime;
    }
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        return penaltyMin(period, lights, arrivalTime);
    }
}