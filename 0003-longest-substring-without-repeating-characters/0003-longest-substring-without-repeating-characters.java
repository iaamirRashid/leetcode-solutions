class Solution {
    public static int lsc(String s) {
       int n = s.length();

       int maxLength = 0;
       int left = 0;
       HashSet<Character> set = new HashSet<>();

       for(int right = 0; right<n; right++) {
         // If a duplicate character is found, shrink the window from the left
         while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
         }
          // Add the current character and update max length
          set.add(s.charAt(right));
          maxLength = Math.max(maxLength, right-left+1);
       }
       return maxLength;
    }
    public int lengthOfLongestSubstring(String s) {
        return lsc(s);
    }
}