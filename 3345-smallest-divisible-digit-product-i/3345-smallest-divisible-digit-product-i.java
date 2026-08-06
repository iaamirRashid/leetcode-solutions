class Solution {
    public static int findNumber(int num) {
        int product = 1;
        while(num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }
    public static int smallestNum(int n, int t) {
        
        while(true) {
            int product = findNumber(n);
            if(product % t == 0) {
                return n;
            }
            n++;
        }
    }
    public int smallestNumber(int n, int t) {
     return smallestNum(n, t);   
    }
}