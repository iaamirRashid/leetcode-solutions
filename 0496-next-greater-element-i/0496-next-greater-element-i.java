class Solution {
    public int[] nextGreater(int[] nums1, int[] nums2) {

    Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Right se Left
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Chhote elements hatao
            while (!stack.isEmpty() &&
                   nums2[stack.peek()] <= nums2[i]) {

                stack.pop();
            }

            // Stack top = Next Greater
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], nums2[stack.peek()]);
            }

            // Current index push
            stack.push(i);
        }

        // nums1 ke according answer
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextGreater(nums1, nums2);
    }
}