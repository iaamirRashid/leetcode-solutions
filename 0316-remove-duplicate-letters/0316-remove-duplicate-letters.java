class Solution {
    public String lettersDuplicate(String s) {
         int n = s.length();

        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        // Store last occurrence of each character
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Already present in stack
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove bigger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && lastIndex[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
    public String removeDuplicateLetters(String s) {
        return lettersDuplicate(s);
    }
}