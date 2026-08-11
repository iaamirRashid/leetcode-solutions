class Solution {
   public static boolean Happy(int n) {
    HashSet<Integer> set = new HashSet<>();

    while(n != 1 && !set.contains(n)) {
         set.add(n);
        n = getSumOfSquare(n);
    }
    return n==1;
   }

   public static int getSumOfSquare(int n) {
 
   int sum = 0;
    while(n>0) {
        int digit = n % 10;

        sum += digit * digit;
        n /= 10;
    }
    return sum;
   }
    public boolean isHappy(int n) {
        return Happy(n);
    }
}