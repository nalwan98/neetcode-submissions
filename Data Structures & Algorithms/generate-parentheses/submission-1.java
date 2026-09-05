class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, n, 0,0,new StringBuilder());
        return res;
    }
    private void generate(List<String> res, int n, int open, int close, StringBuilder s){
        if(close==n){
            res.add(s.toString());
        }
        if(close<open){
            s.append(")");
            generate(res, n, open,close+1,s);
            s.deleteCharAt(s.length()-1);
        }
        if(open<n){
            s.append("(");
            generate(res, n, open+1,close,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
