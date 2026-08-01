class Solution {
    public boolean powerOfFour(int n) {

         if (n <= 0)
            return false;

        // Power of 2 hona chahiye
        if ((n & (n - 1)) != 0)
            return false;

        // Set bit even position par honi chahiye
        return (n & 0x55555555) != 0;
    }
    public boolean isPowerOfFour(int n) {
     return powerOfFour(n);   
    }
}