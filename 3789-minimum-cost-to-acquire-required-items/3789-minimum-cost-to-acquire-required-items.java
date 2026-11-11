class Solution {
    public long minimum(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, cb = costBoth;
        long n1 = need1, n2 = need2;

        long[] candidates = {0, Math.min(n1, n2), Math.max(n1, n2)};

        long ans = Long.MAX_VALUE;
        for (long k : candidates) {
            long cost = k * cb
                      + Math.max(0L, n1 - k) * c1
                      + Math.max(0L, n2 - k) * c2;
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        return minimum(cost1, cost2, costBoth, need1, need2);  // cost1 yahan tha galat
    }
}