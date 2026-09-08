class Solution {
    public int commasCount(int n) {

        if(n < 1000) return 0;
         return n-999;
    }
    public int countCommas(int n) {
        return commasCount(n);
    }
}