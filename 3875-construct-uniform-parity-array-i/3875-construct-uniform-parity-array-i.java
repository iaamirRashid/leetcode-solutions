class Solution {
    public boolean arrayFormUniform(int[] nums1) {

        for (int num : nums1) {
             if (num % 2 != 0) {
            }
        }

        // If at least one odd exists → we can make all odd
        // If all are even → already valid
        return true;
    }
    public boolean uniformArray(int[] nums1) {
        return arrayFormUniform(nums1);
    }
}