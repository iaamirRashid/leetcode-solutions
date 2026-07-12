class Solution {
    public int costMinimum(int[] nums, int k) {
      final long MOD = 1_000_000_007L;

        long resources = k;
        long totalCost = 0;
        long operationNo = 1;

        for (int num : nums) {

            if (resources < num) {

                long need = num - resources;
                long operations = (need + k - 1L) / k;

                // Sum of AP without overflow
                long first = operationNo;
                long last = operationNo + operations - 1;

                long a = first + last;
                long b = operations;

                if ((a & 1) == 0) {
                    a /= 2;
                } else {
                    b /= 2;
                }

                totalCost = (totalCost + ((a % MOD) * (b % MOD)) % MOD) % MOD;

                resources += operations * (long) k;
                operationNo += operations;
            }

            resources -= num;
        }

        return (int) totalCost;
    }
    public int minimumCost(int[] nums, int k) {
        return costMinimum(nums, k);
    }
}