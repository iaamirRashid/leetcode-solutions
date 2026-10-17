class Solution {
    public int swapMin(int[] nums) {
  int n = nums.length;

        // Step 1: Original numbers ko copy karo
        int[] sorted = nums.clone();

        // Step 2: Digit sum, phir number ke according sort karo
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });

        // Step 3: Har element ka target index find karo
        Map<Integer, Integer> targetIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetIndex.put(arr[i], i);
        }

        // Step 4: Cycle detection
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i]) {
                continue;
            }

            int j = i;
            int cycleLength = 0;

            while (!visited[j]) {
                visited[j] = true;
                cycleLength++;

                j = targetIndex.get(nums[j]);
            }

            if (cycleLength > 1) {
                swaps += cycleLength - 1;
            }
        }

        return swaps;
    }

    // Digit sum calculate karne ka function
    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
    public int minSwaps(int[] nums) {
        return swapMin(nums);
    }
}