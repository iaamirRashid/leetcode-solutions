class Solution {
    public int changeMin(String s) {
       int count = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
    public int minChanges(String s) {
        return changeMin(s);
    }
}