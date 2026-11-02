class Solution {
    public int movesMin(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        long medium = nums[n/2];

        long moves = 0;

        for(int num : nums) {
            moves += Math.abs(num - medium);
        }
        return (int) moves;
    }
    public int minMoves2(int[] nums) {
        return movesMin(nums);
    }
}