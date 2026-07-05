class Solution {
    public boolean isMiddleElementUniq(int[] nums) {
        int n = nums.length;

        int mid = n/2;

        for(int i=0; i<n; i++) {
           if(i != mid && nums[mid] == nums[i]) {
            return false;
           }

        }
        return true;
    }
    public boolean isMiddleElementUnique(int[] nums) {
        return isMiddleElementUniq(nums);
    }
}