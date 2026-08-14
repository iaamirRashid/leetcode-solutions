class Solution {
    public int maximumLength(String s) {
       int[] freq = new int[26];

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'a']++;

            // Agar current character 2 se zyada baar aa gaya
            while (freq[ch - 'a'] > 2) {

                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public int maximumLengthSubstring(String s) {
     return maximumLength(s);   
    }
}