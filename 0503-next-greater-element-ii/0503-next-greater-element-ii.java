class Solution {
    public int[] greaterElements(int[] nums) {
       int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            while (!st.isEmpty() &&
                   nums[st.peek()] <= nums[index]) {
                st.pop();
            }

            ans[index] = st.isEmpty() ? -1 : nums[st.peek()];

            st.push(index);
        }

        return ans;
    }
    public int[] nextGreaterElements(int[] nums) {
        return greaterElements(nums);
    }
}