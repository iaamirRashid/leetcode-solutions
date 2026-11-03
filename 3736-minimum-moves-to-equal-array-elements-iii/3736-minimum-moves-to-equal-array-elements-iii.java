class Solution {
    public int movesMin(int[] nums) {
        int n = nums.length;

        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += maxVal - nums[i];
        }
        return sum;
    }
    public int minMoves(int[] nums) {
        return movesMin(nums);
    }
}