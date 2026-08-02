class Solution {
    public int prefixesCount(String s) {
        int n = s.length();

        int zero = 0;
        int one = 0;
        int ans = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
            if(Math.abs(zero - one) <= 1) {
                ans++;
            }
        }
        return ans;
    }
    public int countValidPrefixes(String s) {
        return prefixesCount(s);
    }
}