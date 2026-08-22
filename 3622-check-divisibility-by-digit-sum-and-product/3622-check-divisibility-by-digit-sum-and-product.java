class Solution {
    public boolean divisibilty(int n) {
        int original = n;
        int sum = 0;
        int product = 1;

        while(n > 0) {
            int digit = n%10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        int total = sum + product;

        return original % total == 0;
    }
    public boolean checkDivisibility(int n) {
        return divisibilty(n);
    }
}