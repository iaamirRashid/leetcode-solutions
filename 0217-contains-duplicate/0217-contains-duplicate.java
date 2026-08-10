class Solution {
    public boolean duplicatesContains(int[] nums) {

      int n = nums.length;
      HashMap<Integer, Integer> freq = new HashMap<>();

      for(int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
      }

      for(int count : freq.values()) {
        if(count > 1) {
            return true;
        }
      }
      return false;
    }
    public boolean containsDuplicate(int[] nums) {
        return duplicatesContains(nums);
    }
}