class Solution {
    public int minInsertion(String s) {
        int open = 0;
        int insertions = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // Single ')' means we need one more ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    insertions++;
                }

                // No opening bracket available for this '))'
                if (open == 0) {
                    insertions++;
                } else {
                    open--;
                }
            }
        }

        // Each remaining '(' needs two ')'
        return insertions + 2 * open;
    }
    public int minInsertions(String s) {
        return minInsertion(s);
    }
}