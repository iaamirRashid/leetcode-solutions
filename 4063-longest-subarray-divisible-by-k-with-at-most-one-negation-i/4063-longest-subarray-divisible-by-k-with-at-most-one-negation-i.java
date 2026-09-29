class Solution {
    public int subarrayLongest(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int left = 0; left < n; left++) {

            long sum = 0;

            HashSet<Integer> set = new HashSet<>();

            for (int right = left; right < n; right++) {

                sum += nums[right];

                // 2 * nums[right] % k
                int value = (int)((2L * nums[right]) % k);

                if (value < 0) {
                    value += k;
                }

                set.add(value);

                int rem = (int)(sum % k);

                if (rem < 0) {
                    rem += k;
                }

                // Case 1: Without negation
                if (rem == 0) {
                    ans = Math.max(ans, right - left + 1);
                }

                // Case 2: One element negate kar sakte hain
                else if (set.contains(rem)) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
    public int longestSubarray(int[] nums, int k) {
        return subarrayLongest(nums, k);
    }
}