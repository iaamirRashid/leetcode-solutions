class Solution {
    static final int MOD = 1_000_000_007;
    public int gameDivisible(int[] nums) {
       
        HashSet<Integer> divisors = new HashSet<>();

        // Collect all possible k (>1)
        for (int x : nums) {
            for (int d = 2; d * d <= x; d++) {
                if (x % d == 0) {
                    divisors.add(d);
                    divisors.add(x / d);
                }
            }
            if (x > 1) divisors.add(x);
        }

        // If every element is 1, only possible useful k is 2
        if (divisors.isEmpty()) {
            divisors.add(2);
        }

        long bestDiff = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for (int k : divisors) {

            long curr = (nums[0] % k == 0) ? nums[0] : -nums[0];
            long maxSum = curr;

            // Kadane Algorithm
            for (int i = 1; i < nums.length; i++) {

                long val = (nums[i] % k == 0) ? nums[i] : -nums[i];

                curr = Math.max(val, curr + val);
                maxSum = Math.max(maxSum, curr);
            }

            if (maxSum > bestDiff) {
                bestDiff = maxSum;
                bestK = k;
            } else if (maxSum == bestDiff && k < bestK) {
                bestK = k;
            }
        }

        long ans = ((bestDiff % MOD) * bestK) % MOD;
        ans = (ans + MOD) % MOD;

        return (int) ans;
    }
    public int divisibleGame(int[] nums) {
        return gameDivisible(nums);
    }
}