class Solution {
    public int overlap(int[][] img1, int[][] img2) {
         int n = img1.length;
        int ans = 0;

        // Try every possible row shift
        for (int dr = -(n - 1); dr <= n - 1; dr++) {

            // Try every possible column shift
            for (int dc = -(n - 1); dc <= n - 1; dc++) {

                int count = 0;

                // Traverse img1
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        // We only care about 1s in img1
                        if (img1[i][j] == 1) {

                            int ni = i + dr;
                            int nj = j + dc;

                            // Check if shifted position is inside img2
                            if (ni >= 0 && ni < n &&
                                nj >= 0 && nj < n &&
                                img2[ni][nj] == 1) {

                                count++;
                            }
                        }
                    }
                }

                // Maximum overlap
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        return overlap(img1, img2);
    }
}