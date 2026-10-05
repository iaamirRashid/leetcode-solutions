class Solution {
    public int paranthesesOfScore(String s) {
     Stack<Integer> st = new Stack<>();
        st.push(0);

        for(char ch : s.toCharArray()) {

            if(ch == '(') {
                st.push(0);
            } 
            else {
                int inner = st.pop();

                int score = (inner == 0) ? 1 : 2 * inner;

                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }
    public int scoreOfParentheses(String s) {
        return  paranthesesOfScore(s);
    }
}