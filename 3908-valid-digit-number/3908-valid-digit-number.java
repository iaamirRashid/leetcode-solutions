class Solution {
    public boolean digitValid(int n, int x) {
        int temp = n;

        boolean found = false;

        while(temp > 0) {
            if(temp % 10 == x) found = true;
            temp /= 10;
        }

        while(n>=10) {
            n /= 10;
        }

        if(n == x) return false;

        return found;
    }
    public boolean validDigit(int n, int x) {
        return digitValid(n, x);
    }
}