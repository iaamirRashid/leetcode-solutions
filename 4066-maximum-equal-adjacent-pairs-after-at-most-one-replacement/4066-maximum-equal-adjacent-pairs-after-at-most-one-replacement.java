class Solution {
    public int adjacentPairs(int[] nums) {
        int n = nums.length;

        // Already existing equal adjacent pairs
        int base = 0;

        // x -> (y -> count)
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {

            int a = nums[i];
            int b = nums[i + 1];

            // Already equal pair
            if (a == b) {
                base++;
            } 
            else {
                // a -> b
                map.putIfAbsent(a, new HashMap<>());
                Map<Integer, Integer> temp1 = map.get(a);

                temp1.put(b, temp1.getOrDefault(b, 0) + 1);

                // b -> a
                map.putIfAbsent(b, new HashMap<>());
                Map<Integer, Integer> temp2 = map.get(b);

                temp2.put(a, temp2.getOrDefault(a, 0) + 1);
            }
        }

        // Maximum new pairs obtained by one replacement
        int maxGain = 0;

        for (Map<Integer, Integer> innerMap : map.values()) {

            for (int count : innerMap.values()) {
                maxGain = Math.max(maxGain, count);
            }
        }

        return base + maxGain;
    }
    public int maxEqualAdjacentPairs(int[] nums) {
        return adjacentPairs(nums);
    }
}