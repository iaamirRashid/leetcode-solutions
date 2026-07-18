class Solution {
    public long maxValue(int n, int s, int m) {
        long k = n/2;

         return (long) s + k * m - Math.max(0, k-1);
    }
    public long maximumValue(int n, int s, int m) {
       return maxValue(n, s, m);   
    }
}