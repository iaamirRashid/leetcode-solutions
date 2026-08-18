class Solution {
    public int IntegerLarge(int[] nums, int k) {
      int n = nums.length;

        // Case 1: Only one subarray
        if (k == n) {
            int max = Integer.MIN_VALUE;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Count frequency
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;

        // Case 2: k == 1
        if (k == 1) {
            for (int num : nums) {
                if (map.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }
            return ans;
        }

        // Case 3: 1 < k < n
        if (map.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (map.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
          
    }
    public int largestInteger(int[] nums, int k) {
      return  IntegerLarge(nums, k);
    }
}