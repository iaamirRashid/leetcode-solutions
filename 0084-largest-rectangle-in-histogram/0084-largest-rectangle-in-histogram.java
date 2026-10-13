class Solution {
    public static int largestArea(int heights[]) {
         int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int right[] = new int[n]; // Next smaller on right
        int left[] = new int[n];  // Next smaller on left

        // Fill right[] - next smaller on right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Clear stack for next loop
        st.clear();

        // Fill left[] - next smaller on left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Now calculate area
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int currArea = heights[i] * width;
            ans = Math.max(ans, currArea);
        }

        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        return largestArea(heights);
    }
}