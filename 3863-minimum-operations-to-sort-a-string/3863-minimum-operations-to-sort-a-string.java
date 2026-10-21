class Solution {
    public int operationMin(String s) {
          int n = s.length();

        // Check if string is already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;

        // A reversed string of length 2 cannot be sorted
        if (n == 2) return -1;

        char mn = 'z';
        char mx = 'a';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            mn = (char) Math.min(mn, ch);
            mx = (char) Math.max(mx, ch);
        }

        // One operation is enough
        if (s.charAt(0) == mn ||
            s.charAt(n - 1) == mx) {
            return 1;
        }

        // Check middle characters
        for (int i = 1; i < n - 1; i++) {
            char ch = s.charAt(i);

            if (ch == mn || ch == mx) {
                return 2;
            }
        }

        // Otherwise, three operations are required
        return 3;
    }
    public int minOperations(String s) {
        return operationMin(s);
    }
}