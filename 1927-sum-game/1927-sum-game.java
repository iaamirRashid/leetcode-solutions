class Solution {

    public boolean game(String num) {

        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // First half
        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        // Second half
        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int qDiff = leftQ - rightQ;
        int sumDiff = leftSum - rightSum;

        // Bob can make the sums equal
        if (qDiff % 2 == 0 &&
            sumDiff == -9 * (qDiff / 2)) {
            return false;
        }

        // Otherwise Alice wins
        return true;
    }

    public boolean sumGame(String num) {
        return game(num);
    }
}