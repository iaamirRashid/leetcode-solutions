class Solution {
    //concept sliding window + set
    public int longestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        return longestSubstring(s);
    }
}