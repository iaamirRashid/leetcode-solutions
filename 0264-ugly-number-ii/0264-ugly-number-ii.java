class Solution {
    public int uglyNumber(int n) {
        
    int dp[] = new int[n];

    dp[0] = 1;

    int i2 = 0;
    int i3 = 0;
    int i5 = 0;

    for(int i=1; i<n; i++) {
      int next2 = dp[i2] * 2;
      int next3 = dp[i3] * 3;
      int next5 = dp[i5] * 5;

      int uglyNum = Math.min(next2, Math.min(next3, next5));

      dp[i] = uglyNum;

      if(uglyNum == next2) i2++;
      if(uglyNum == next3) i3++;
      if(uglyNum == next5) i5++;
    }
    return dp[n-1];
    }
    public int nthUglyNumber(int n) {
        return uglyNumber(n);
    }
}