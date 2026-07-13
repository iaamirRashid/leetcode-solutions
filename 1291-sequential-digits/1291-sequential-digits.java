class Solution {
    public List<Integer> digitsSequential(int low, int high) {
             List<Integer> ans = new ArrayList<>();

        String digits = "123456789";

        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        // Generate numbers of every possible length
        for (int len = lowLength; len <= highLength; len++) {

            // Sliding window on "123456789"
            for (int i = 0; i + len <= 9; i++) {

                String str = digits.substring(i, i + len);

                int num = Integer.parseInt(str);

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        return  digitsSequential(low, high);
    }
}