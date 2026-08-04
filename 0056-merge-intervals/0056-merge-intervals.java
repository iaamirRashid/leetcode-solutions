class Solution {
    public static int[][] Merge(int[][] intervals) {
// Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        // Step 2: Add first interval
        ans.add(intervals[0]);
        // Step 3: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] last = ans.get(ans.size() - 1);
            // Overlap
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
            // No overlap
            else {
                ans.add(intervals[i]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public int[][] merge(int[][] intervals) {
        return Merge(intervals);
    }
}