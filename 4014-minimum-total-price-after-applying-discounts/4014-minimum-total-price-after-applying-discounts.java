class Solution {
    public double priceMinimum(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double ans = 0;

        int n = prices.length;
        int m = discounts.length;

        int i = n-1;
        int j = m-1;

        while(i>=0 && j>=0) {
            ans += prices[i] * (100.0 - discounts[j]) / 100.0;
            i--;
            j--;
        }
        // Remaining prices no discount
        while(i >= 0) {
            ans += prices[i];
            i--;
        }
        return ans;
    }
    public double minPrice(int[] prices, int[] discounts) {
        return priceMinimum(prices, discounts);
    }
}