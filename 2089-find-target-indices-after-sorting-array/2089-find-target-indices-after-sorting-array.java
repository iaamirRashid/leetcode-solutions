class Solution {
    public List<Integer> indicesTarget(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(nums[i] == target) {
                list.add(i);
            }
        }
        return list;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        return indicesTarget(nums, target);
    }
}