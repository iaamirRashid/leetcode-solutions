class Solution {
    public static int pairRemoval(int nums[]) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums) list.add(num);

        int operations = 0;

        while(!isSorted(list)) {
            int minSum = Integer.MAX_VALUE;
            int idx = -1;

            for(int i=0; i<list.size()-1; i++) {
                int sum = list.get(i) + list.get(i+1);
                if(sum < minSum)  {
                    minSum = sum;
                    idx = i;
                }
            }
              // Replace the pair with their sum
            int sum = list.get(idx) + list.get(idx + 1);
            list.set(idx, sum);
            list.remove(idx + 1);

            operations++;
            
        }
        return operations;
        
    }

     // Helper function to check if list is non-decreasing
    private static boolean isSorted(List<Integer> list) {
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    
    public int minimumPairRemoval(int[] nums) {
        return  pairRemoval(nums);
    }
}