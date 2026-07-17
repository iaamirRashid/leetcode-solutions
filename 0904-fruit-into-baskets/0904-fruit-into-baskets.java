class Solution {
    public int fruitsTotal(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++) {
           map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

           while(map.size() > 2) {
            if(map.get(fruits[left]) == 1) {
                map.remove(fruits[left]);
            } else {
                map.put(fruits[left], map.get(fruits[left]) - 1);
            }
            left++;
           }
           maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public int totalFruit(int[] fruits) {
        return fruitsTotal(fruits);
    }
}