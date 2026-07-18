class Solution {
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
    public int gcdFind(int[] nums) {
        int n = nums.length;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            minVal = Math.min(minVal, nums[i]);
        }
        return gcd(minVal, maxVal);
    }
    public int findGCD(int[] nums) {
        return gcdFind(nums);
    }
}