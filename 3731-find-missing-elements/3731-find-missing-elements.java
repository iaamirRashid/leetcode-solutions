class Solution {
    public List<Integer> missingElements(int[] nums) {
      Arrays.sort(nums); // ✅ sort karna zaroori hai

        int n = nums.length;
        int min = nums[0];
        int max = nums[n - 1];

        List<Integer> missing = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!contains(nums, i)) {
                missing.add(i);
            }
        }
        return missing;
    }

    public boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> findMissingElements(int[] nums) {
        return missingElements(nums);
    }
}