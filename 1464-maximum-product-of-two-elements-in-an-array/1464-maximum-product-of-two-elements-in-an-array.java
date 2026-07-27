class Solution {
    public int maximumProd(int[] nums) {
        int n = nums.length;

        int maxPro = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int pro = (nums[i] - 1) * (nums[j] - 1);
                maxPro = Math.max(maxPro, pro);
            }
        }
        return maxPro;
    }
    public int maxProduct(int[] nums) {
        return maximumProd(nums);
    }
}