class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        gen(n, 0, 0, res, sb);
        return res;
    }
    private void gen(int n, int close, int open, List<String> list, StringBuilder st){
        if(close==open && open==n){
            list.add(st.toString());
        }
        if(open<n){
            st.append("(");
            gen(n, close, open+1, list, st);
            st.deleteCharAt(st.length() - 1);
        }
        if(close<open){
            st.append(")");
            gen(n, close+1, open, list, st);
            st.deleteCharAt(st.length() - 1);
        }
        
    }
}
