class Solution {
    public List<List<Integer>> sumCombination(int candidates[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, 0, curr, result);
        return result;
    }
    public void backtrack(int candidates[], int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) {
            return;
        }

       for (int i = start; i < candidates.length; i++) {  // ✅ use start instead of 0
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, curr, result); // i not i+1, since reuse allowed
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return sumCombination(candidates, target);
    }
}