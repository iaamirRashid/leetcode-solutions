class Solution {
    public List<List<Integer>> kSmallest(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
               int sum = nums1[i] + nums2[j]; 

                if (maxHeap.size() < k) { 
                    maxHeap.offer(new int[]{sum, i, j}); 
                } 
                else if (maxHeap.peek()[0] > sum) { 
                    maxHeap.poll(); 
                    maxHeap.offer(new int[]{sum, i, j}); 
                } 
                else { 
                    break; 
                } 
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            ans.add(Arrays.asList(nums1[curr[1]], nums2[curr[2]]));
        }
        Collections.reverse(ans);

        return ans;
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        return kSmallest(nums1, nums2, k);
    }
}