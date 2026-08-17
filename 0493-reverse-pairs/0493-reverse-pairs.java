class Solution {
   public static int pariReverse(int nums[]) {
    return  mergeSort(nums,  0, nums.length - 1);
   }

   public static int mergeSort(int nums[], int si, int ei) {
        if(si >= ei) {
            return 0;
        }

        int mid = si + (ei - si)/2;
        int count = mergeSort(nums, si, mid) + mergeSort(nums, mid + 1, ei);
        
        // Count reverse pairs here

        int j = mid+1;

        for(int i=si; i<=mid; i++) {
           while(j<=ei && (long) nums[i] > 2L * nums[j]) {
              j++;
           } 
           count += (j - (mid + 1));
        }
        merge(nums, si, mid, ei);
        return count;
   }

   public static void merge(int nums[], int si, int mid, int ei) {

     int[] temp = new int[ei - si + 1];
     int i = si;
     int j = mid+1;
     int k = 0;

     while (i <= mid && j <= ei) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

     while(i<=mid) {
        temp[k++] = nums[i++];
     }
     while(j<=ei) {
        temp[k++] = nums[j++];
     }

     for(i=si, k=0; i<=ei; i++, k++) {
        nums[i] = temp[k];
     }
   }
    public int reversePairs(int[] nums) {
        return pariReverse(nums);
    }
}