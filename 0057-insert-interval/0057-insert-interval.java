class Solution {
    public int[][] insetInterval(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // Case 1: Current interval completely before newInterval
            if (interval[1] < newInterval[0]) {
                ans.add(interval);
            }  // Case 2: Current interval completely after newInterval
            else if (interval[0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = interval;
            }// Case 3: Overlapping intervals
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the last merged interval
        ans.add(newInterval);

        return ans.toArray(new int[ans.size()][]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        return  insetInterval(intervals, newInterval);
    }
}