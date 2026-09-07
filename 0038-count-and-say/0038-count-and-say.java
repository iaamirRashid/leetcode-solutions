class Solution {
    public String sayAndCount(int n) {
        
        String result = "1";

        for(int k=1; k<n; k++) {
         
         StringBuilder next = new StringBuilder();

         int i=0;

         while(i < result.length()) {
            char ch = result.charAt(i);
            int count = 0;

            while(i < result.length() && result.charAt(i) == ch) {
                count++;
                i++;
            }
            next.append(count);
            next.append(ch);
         }
         result = next.toString();
        }
        return result;
    }
    public String countAndSay(int n) {
        return sayAndCount(n);
    }
}