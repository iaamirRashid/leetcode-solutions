class Solution {
    public int[] arrangeArray(int[] nums) {
        int n = nums.length;

        int[] freq = new int[101];

        for(int x : nums) {
            freq[x]++;
        }

        int[] ans = new int[n];

        int idx = 0;

        while(true) {
            boolean added = false;

            for(int i=1; i<=100; i++) {
                
                if(freq[i] > 0) {

                    ans[idx++] = i;
                    freq[i]--;

                    added = true;
                }
            }

            if(!added) {
                break;
            }
        }
        return ans;
    }
    public int[] rearrangeArray(int[] nums) {
        return arrangeArray(nums);
    }
}