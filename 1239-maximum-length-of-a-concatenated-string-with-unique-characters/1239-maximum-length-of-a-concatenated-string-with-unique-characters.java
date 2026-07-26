class Solution {
    public int lengthMax(List<String> arr) {

        List<String> dp = new ArrayList<>();

        dp.add("");

        int maxLen = 0;

        for(String str : arr) {

            int size = dp.size();

            for(int i=0; i<size; i++) {
                String combined = dp.get(i) + str;

                if(noDuplicate(combined)) {
                    dp.add(combined);

                    maxLen = Math.max(maxLen, combined.length());
                }
            }
        }
        return maxLen;
    }

    private boolean noDuplicate(String str) {

        boolean[] seen = new boolean[26];

        for(char ch : str.toCharArray()) {

            int index = ch - 'a';
            if(seen[index]) {
                return false;
            }
            seen[index] = true;
        }
    return true;

    }

    public int maxLength(List<String> arr) {
        return lengthMax(arr);
    }
}