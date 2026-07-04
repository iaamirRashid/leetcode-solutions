/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
       
    HashMap<Integer, Integer> freq = new HashMap<>();

    public int sumTreeFrequentFind(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumTreeFrequentFind(root.left);
        int rightSum = sumTreeFrequentFind(root.right);

        int totalSum = root.val + leftSum + rightSum;

        freq.put(totalSum, freq.getOrDefault(totalSum, 0) + 1);

        return totalSum;
    }

    public int[] findFrequentTreeSums(TreeNode root) {

        sumTreeFrequentFind(root);

        int maxFreq = 0;

        for (int value : freq.values()) {
            maxFreq = Math.max(maxFreq, value);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int sum : freq.keySet()) {
            if (freq.get(sum) == maxFreq) {
                list.add(sum);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        return findFrequentTreeSums(root);
    }
}