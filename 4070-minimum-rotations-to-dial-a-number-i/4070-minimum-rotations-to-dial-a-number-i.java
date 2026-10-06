class Solution {
    public int rotations(String s) {
        int n = s.length();

        int prev = 0;
        int ans = 0;

        for(int i=0; i<n; i++) {
            int curr = s.charAt(i) - '0';

            int diff = Math.abs(curr - prev);

            int rotation = Math.min(diff, 10-diff);

            ans += rotation;
            prev = curr;
        }
        return ans;
    }
    public int minRotations(String s) {
        return rotations(s);
    }
}