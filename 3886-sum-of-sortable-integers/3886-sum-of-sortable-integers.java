class Solution {
      public int sumOfSortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {

            if (n % k != 0) {
                continue;
            }

            boolean possible = true;

            for (int start = 0; start < n; start += k) {

                if (!isCyclicRotation(nums, sorted, start, k)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans += k;
            }
        }

        return ans;
    }

    private boolean isCyclicRotation(int[] nums, int[] sorted, int start, int k) {

        int[] lps = new int[k];

        // Build LPS array for the target sorted block
        for (int i = 1, len = 0; i < k; ) {
            if (sorted[start + i] == sorted[start + len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        // Search target block in the circular original block
        // We examine 2*k - 1 elements to cover all rotations.
        for (int i = 0, j = 0; i < 2 * k - 1; ) {

            int value = nums[start + (i % k)];

            if (value == sorted[start + j]) {
                i++;
                j++;

                if (j == k) {
                    return true;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
    public int sortableIntegers(int[] nums) {
        return  sumOfSortableIntegers(nums);
    }
}