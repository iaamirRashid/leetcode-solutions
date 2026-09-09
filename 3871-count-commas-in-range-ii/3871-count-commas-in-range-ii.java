class Solution {
    public long commasCount(long n) {
          long total = 0;
        long start = 1000;
        int commas = 1;

        while (start <= n) {
            long end = start * 1000 - 1;
            long count = Math.min(n, end) - start + 1;

            total += count * commas;

            start *= 1000;
            commas++;
        }

        return total;
    }
    public long countCommas(long n) {
      return commasCount(n);  
    }
}