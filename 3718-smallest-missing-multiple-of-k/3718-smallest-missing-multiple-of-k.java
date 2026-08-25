class Solution {
    public int multipleMissing(int nums[], int k) {
       HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int multiple = k;

        while(true) {
            if(!set.contains(multiple)) {
                return multiple;
            }

            multiple += k;
        }
    }
    public int missingMultiple(int[] nums, int k) {
        return multipleMissing(nums, k);
    }
}