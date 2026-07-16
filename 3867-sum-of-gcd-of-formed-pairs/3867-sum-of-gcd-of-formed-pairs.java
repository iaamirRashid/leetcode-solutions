class Solution {

    public long sumGcd(int[] nums) {

        int n = nums.length;
        int gridGcd[] = new int[n];

        int maxVal = 0;

        for(int i=0;i<n;i++){
            maxVal = Math.max(maxVal, nums[i]);
            gridGcd[i] = gcd(nums[i], maxVal);
        }

        Arrays.sort(gridGcd);

        long sum = 0;

        int left = 0;
        int right = n - 1;

        while(left < right){
            sum += gcd(gridGcd[left], gridGcd[right]);
            left++;
            right--;
        }

        return sum;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        return sumGcd(nums);
    }
}