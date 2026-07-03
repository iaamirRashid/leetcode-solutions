class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWord(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        List<String> ans = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                dfs(board, i, j, root, ans);

            }
        }

        return ans;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node,
                     List<String> ans) {

        if (i < 0 || j < 0 ||
            i >= board.length ||
            j >= board[0].length)
            return;

        char ch = board[i][j];

        if (ch == '#')
            return;

        if (node.children[ch - 'a'] == null)
            return;

        node = node.children[ch - 'a'];

        if (node.word != null) {

            ans.add(node.word);

            // duplicate avoid
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node, ans);
        dfs(board, i - 1, j, node, ans);
        dfs(board, i, j + 1, node, ans);
        dfs(board, i, j - 1, node, ans);

        board[i][j] = ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
     return findWord(board, words);   
    }
}