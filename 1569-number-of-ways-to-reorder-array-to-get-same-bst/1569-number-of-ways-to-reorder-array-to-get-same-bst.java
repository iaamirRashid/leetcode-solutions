class Solution {
     static final int MOD = 1_000_000_007;
    int[][] comb;

    public int waysOfNum(int[] nums) {
        int n = nums.length;

        // Step 1: Precompute combinations using Pascal's Triangle
        comb = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (int) (((long) comb[i - 1][j - 1]
                    + comb[i - 1][j]) % MOD);
            }
        }

        // Step 2: Calculate ways including the original ordering
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        long result = ways(list);

        // Exclude the original ordering
        return (int) ((result - 1 + MOD) % MOD);
    }

    private long ways(List<Integer> nums) {
        // Base case
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Step 1: Divide into left and right subtrees
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);

            if (num < root) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        int L = left.size();
        int R = right.size();

        // Step 2: Count valid orderings of both subtrees
        long leftWays = ways(left);
        long rightWays = ways(right);

        // Step 3: Interleave left and right elements
        long result = comb[L + R][L];
        result = result * leftWays % MOD;
        result = result * rightWays % MOD;

        return result;
    }
    public int numOfWays(int[] nums) {
        return waysOfNum(nums);
    }
}