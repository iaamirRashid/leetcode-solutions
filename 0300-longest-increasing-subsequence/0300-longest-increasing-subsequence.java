class Solution {
 
 public static int lis(int nums[]) {
    int n = nums.length;
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int dp[] = new int[n+1];

    for(int i=0; i<n; i++) {
        dp[i] = 1;
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<i; j++) {
           if(nums[i]> nums[j]) {
             dp[i] = Math.max(dp[i], dp[j]+1);
           }
        }
    }

int maxLength = 0;
for(int i=0; i<n; i++) {
    maxLength = Math.max(maxLength, dp[i]);
}
return maxLength;



 }

    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }
}