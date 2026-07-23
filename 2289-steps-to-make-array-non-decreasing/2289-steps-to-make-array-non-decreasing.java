class Solution {
    public int stepsTotal(int[] nums) {
      int n = nums.length;

        int[] dp = new int[n];

        Stack<Integer> stack = new Stack<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int maxStep = 0;

            // Remove smaller/equal elements
            while (!stack.isEmpty() &&
                   nums[stack.peek()] <= nums[i]) {

                maxStep = Math.max(
                    maxStep,
                    dp[stack.peek()]
                );

                stack.pop();
            }

            // Greater element exists on left
            if (!stack.isEmpty()) {
                dp[i] = maxStep + 1;
            }

            ans = Math.max(ans, dp[i]);

            stack.push(i);
        }

        return ans;

    }
    public int totalSteps(int[] nums) {
        return stepsTotal(nums);
    }
}