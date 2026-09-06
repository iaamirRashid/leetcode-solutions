class Solution {
    public int goodRotations(int[] nums) {
        int n = nums.length;

        int half = n/2;

        int totalSum = 0;

        for(int x : nums) {
            totalSum += x;
        }

        int windowSum = 0;

        for(int i=0; i<half; i++) {
            windowSum += nums[i];
        }

        int count = 0;

        for(int start = 0; start<n; start++) {
            int otherSum = totalSum - windowSum;
            if(windowSum > otherSum) {
                count++;
            }
            windowSum = windowSum - nums[start] + nums[(start + half)%n];
        }
        return count;
    }
    public int countGoodRotations(int[] nums) {
        return goodRotations(nums);
    }
}