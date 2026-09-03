class Solution {
    public boolean arrayUniform(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean allEven = true;

        for(int num : nums1) {
            min = Math.min(min, num);
            if(num % 2 != 0) {
                allEven = false;
            }
        }

          // Case 1: minimum is odd → can make all odd
        if (min % 2 != 0) return true;

        // Case 2: minimum is even → only possible if all are already even
        return allEven;
    }
    public boolean uniformArray(int[] nums1) {
        return arrayUniform(nums1);
    }
}