class Solution {
    public static List<String> generate(int n) {
     List<List<String>> dp = new ArrayList<>();

        // dp[0] = [""]
        dp.add(new ArrayList<>());
        dp.get(0).add("");

        for (int i = 1; i <= n; i++) {

            List<String> current = new ArrayList<>();

            // left = j pairs
            // right = i - 1 - j pairs
            for (int j = 0; j < i; j++) {

                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - 1 - j)) {

                        String str = "(" + left + ")" + right;

                        current.add(str);
                    }
                }
            }

            dp.add(current);
        }

        return dp.get(n);
    }

    public List<String> generateParenthesis(int n) {
         return generate(n);
    }
}