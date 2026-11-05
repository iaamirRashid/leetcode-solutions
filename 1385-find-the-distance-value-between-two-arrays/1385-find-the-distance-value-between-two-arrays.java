class Solution {
    public int distanceValue(int[] arr1, int[] arr2, int d) {
         int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean valid = true;

            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    valid = false;
                    break; // ek bhi close element mila to aage check ki zaroorat nahi
                }
            }

            if (valid) count++;
        }

        return count;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return distanceValue(arr1, arr2, d);
    }
}