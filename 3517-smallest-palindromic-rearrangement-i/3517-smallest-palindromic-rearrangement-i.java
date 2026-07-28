class Solution {
    public static String palindromLexico(String s) {
        
        int freq[] = new int[26];
        
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        
        StringBuilder left = new StringBuilder();
        StringBuilder center = new StringBuilder();
        
        for(int i=0; i<26; i++) {
            if(freq[i]%2 == 1) {
                center.append((char)(i+'a'));
            }
            for(int j=0; j<freq[i]/2; j++) {
                left.append((char)(i+'a'));
            }
        }
        
        String leftPart = left.toString();
        String rightPart = left.reverse().toString();
        
        return leftPart + center + rightPart;
       
    }
    public String smallestPalindrome(String s) {
        return palindromLexico(s);
    }
}