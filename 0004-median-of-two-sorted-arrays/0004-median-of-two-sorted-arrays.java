class Solution {
    public static List<Integer> merge(int nums1[], int nums2[]) {

        ArrayList<Integer> merged = new ArrayList<>();

        int i=0; int j = 0;
       while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]) {
                merged.add(nums1[i]);
                i++;
            } else {
                merged.add(nums2[j]);
                j++;
            }
       }
        while(i<nums1.length) {
        merged.add(nums1[i]);
        i++;
       }
       while(j<nums2.length) {
        merged.add(nums2[j]);
        j++;
       }
       return merged;
    }

    public static double findMedian(int nums1[], int nums2[]) {
        List<Integer> merged = merge(nums1, nums2);
        int n = merged.size();

        if(n%2 == 1) {
            return merged.get(n/2);
        } else {
            return ((double)merged.get(n/2-1)+merged.get(n/2))/2.0;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     return findMedian(nums1, nums2);   
    }
}