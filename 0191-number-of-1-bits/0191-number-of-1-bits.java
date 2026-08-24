class Solution {
    public int weightHamming(int n) {

        int count = 0;

      for(int i=0; i<32; i++) {
        int bitmask = (1 << i);

        if((n & bitmask) != 0) {
            count++;
        }
      }
      return count;
    }
    public int hammingWeight(int n) {
        return  weightHamming(n);
    }
}