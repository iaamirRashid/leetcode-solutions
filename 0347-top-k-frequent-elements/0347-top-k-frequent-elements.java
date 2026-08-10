class Solution {
    public int[] topKfrequent(int[] nums, int k) {
        
     HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for (int num : freq.keySet()) {
            maxHeap.add(num);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
    public int[] topKFrequent(int[] nums, int k) {
        return topKfrequent(nums, k);
    }
}