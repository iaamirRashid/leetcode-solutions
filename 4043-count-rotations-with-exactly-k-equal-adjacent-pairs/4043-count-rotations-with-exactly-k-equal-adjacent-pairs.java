class Solution {
    public int rotation(String s, int k) {
        int n = s.length();

        if(n == 1) {
            return k == 0 ? 1 : 0;
        }


        int equalPairs = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == s.charAt((i+1) % n)) {
                equalPairs++;
            }
        }

        if(k == equalPairs) {
            return n-equalPairs;
            
        } if(k == equalPairs-1) {
            return equalPairs;
        }
        return 0;
    }
    public int countRotations(String s, int k) {
        return rotation(s, k);
    }
}