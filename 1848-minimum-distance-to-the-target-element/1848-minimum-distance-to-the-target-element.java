class Solution {
    public int minDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int minDis = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(nums[i] == target) {
                minDis = Math.min(minDis, Math.abs(i-start));
            }
        }
        return minDis;
    }
    public int getMinDistance(int[] nums, int target, int start) {
        return minDistance(nums, target, start);
    }
}