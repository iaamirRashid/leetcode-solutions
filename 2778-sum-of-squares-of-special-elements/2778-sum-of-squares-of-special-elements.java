
class Solution {
    public int sumOfSquare(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }
    public int sumOfSquares(int[] nums) {
        return sumOfSquare(nums);
    }
}