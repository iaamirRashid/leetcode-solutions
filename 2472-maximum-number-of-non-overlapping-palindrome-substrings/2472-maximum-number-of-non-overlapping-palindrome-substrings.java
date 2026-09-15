class Solution {
    public int palindromMax(String s, int k) {

        int n = s.length();

        // palindrome[i][j] = true if s[i...j] is palindrome
        boolean[][] palindrome = new boolean[n][n];

        // Build palindrome table
        for (int len = 1; len <= n; len++) {

            for (int left = 0; left + len - 1 < n; left++) {

                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right)) {

                    if (len <= 2) {
                        palindrome[left][right] = true;
                    } 
                    else {
                        palindrome[left][right] =
                            palindrome[left + 1][right - 1];
                    }
                }
            }
        }

        // dp[i] = maximum palindromes using first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't take a palindrome ending at i-1
            dp[i] = dp[i - 1];

            // Try every substring ending at i-1
            for (int left = 0; left <= i - k; left++) {

                if (palindrome[left][i - 1]) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[left] + 1
                    );
                }
            }
        }

        return dp[n];
    }
    public int maxPalindromes(String s, int k) {
        return palindromMax(s, k);
    }
} 