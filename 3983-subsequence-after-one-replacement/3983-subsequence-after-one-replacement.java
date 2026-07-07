class Solution {
    public boolean checkSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        if (n > m) return false;

        // pre[i] = t me position jahan tak s[0..i-1] match ho gaya
        int[] pre = new int[n + 1];
        pre[0] = -1;

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j == m) {
                pre[i + 1] = m;
            } else {
                pre[i + 1] = j;
                j++;
            }
        }

        // Agar already subsequence hai
        if (pre[n] != m) return true;

        // suf[i] = t me latest position jahan se s[i..] match ho sakta hai
        int[] suf = new int[n + 1];
        suf[n] = m;

        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && t.charAt(j) != s.charAt(i)) {
                j--;
            }
            if (j < 0) {
                suf[i] = -1;
            } else {
                suf[i] = j;
                j--;
            }
        }

        // Har index ko replace karke check karo
        for (int i = 0; i < n; i++) {
            int left = pre[i];
            int right = suf[i + 1];

            // left aur right ke beech kam se kam ek character hona chahiye
            if (left + 1 < right) {
                return true;
            }
        }

        return false;
    }
    public boolean canMakeSubsequence(String s, String t) {
     return checkSubsequence(s, t);
    }
}