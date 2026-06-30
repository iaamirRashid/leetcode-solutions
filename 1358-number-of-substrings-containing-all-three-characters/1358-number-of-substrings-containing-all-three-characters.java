class Solution {
    public int substringOfNumer(String s) {
        int n = s.length();

        int[] freq = new int[3]; // 0 -> a, 1 -> b, 2 -> c
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                ans += (n - right);

                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
    public int numberOfSubstrings(String s) {
        return substringOfNumer(s);
    }
}