class Solution {
    public List<List<Integer>> subSets(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, 0, curr, result);
        return result;
    }

    public void backtrack(int nums[], int start, List<Integer> curr, List<List<Integer>> result) {
        
            result.add(new ArrayList<>(curr));


        for(int i=start; i<nums.length; i++) {
             curr.add(nums[i]);
             backtrack(nums, i+1, curr, result);
             curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        return subSets(nums);
    }
}