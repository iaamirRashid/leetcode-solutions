class Solution {
    public boolean anagram(String s, String t) {

        s = s.toLowerCase();
        t = t.toLowerCase();

        if(s.length() == t.length()) {
             char[] sCharArray = s.toCharArray();
             char[] tCharArray = t.toCharArray();

             Arrays.sort(sCharArray);
             Arrays.sort(tCharArray);

             boolean result = Arrays.equals(sCharArray, tCharArray);
             return result;
        }
        return false;    
    }
    public boolean isAnagram(String s, String t) {
        return anagram(s, t);
    }
}