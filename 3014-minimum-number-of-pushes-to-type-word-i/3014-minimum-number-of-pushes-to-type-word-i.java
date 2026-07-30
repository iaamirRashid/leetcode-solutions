class Solution {
    public int pushesMinimum(String word) {
           int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            ans += (i / 8) + 1;
        }

        return ans;
    }
    public int minimumPushes(String word) {
        return pushesMinimum(word);
    }
}