class Solution {
    public long alternatingSum(int[] nums) {
       int n = nums.length;
        long[] squares = new long[n];

        // Step 1: Calculate squares
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        // Step 2: Sort in ascending order
        Arrays.sort(squares);

        long score = 0;

        // Step 3: Subtract smallest n/2 squares
        // Add all remaining squares
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                score -= squares[i];
            } else {
                score += squares[i];
            }
        }

        return score;
    }
    public long maxAlternatingSum(int[] nums) {
        return alternatingSum(nums);
    }
}