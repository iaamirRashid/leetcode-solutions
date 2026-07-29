class Solution {

    public boolean kSubsetsPartition(int[] nums, int k) {
         int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        // Agar koi number target se bada hai
        for (int num : nums) {
            if (num > target) {
                return false;
            }
        }

        int size = 1 << n;

        // dp[mask] = current subset me kitna sum bhara hai
        int[] dp = new int[size];

        Arrays.fill(dp, -1);

        // Koi element use nahi hua
        dp[0] = 0;

        // TABULATION
        for (int mask = 0; mask < size; mask++) {

            // Ye state possible nahi hai
            if (dp[mask] == -1) {
                continue;
            }

            for (int i = 0; i < n; i++) {

                // Agar nums[i] already include hai
                if ((mask & (1 << i)) != 0) {
                    continue;
                }

                // Include karne par target cross ho raha hai
                if (dp[mask] + nums[i] > target) {
                    continue;
                }

                // nums[i] ko INCLUDE karo
                int newMask = mask | (1 << i);

                dp[newMask] =
                    (dp[mask] + nums[i]) % target;
            }
        }

        // Saare elements use hue aur subset complete hua
        return dp[size - 1] == 0;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        return kSubsetsPartition(nums, k);
    }
}