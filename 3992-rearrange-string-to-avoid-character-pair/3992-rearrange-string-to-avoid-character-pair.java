class Solution {
    public String stringRearrange(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == y) {
                sb.append(ch);
            }
        }

        for (char ch : s.toCharArray()) {
            if (ch != x && ch != y) {
                sb.append(ch);
            }
        }

        for (char ch : s.toCharArray()) {
            if (ch == x) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
    public String rearrangeString(String s, char x, char y) {
        return stringRearrange(s, x, y);
    }
}