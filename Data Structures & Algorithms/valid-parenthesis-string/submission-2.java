class Solution {
    public boolean checkValidString(String s) {
      Stack<Character> stack = new Stack<>();
      Stack<Integer> in = new Stack<>();
      List<Integer> ls = new ArrayList<>();
      for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c=='('){
            in.push(i);
        }
        if(c==')'){
            if(in.size()==0){
                if(ls.size()==0){
                    return false;
                }
                else{
                    ls.remove(0);
                }
            }
            else{
                in.pop();
            }
        }
        if(c=='*'){
            ls.add(i);
        }
      }
      if(in.size()>0){
        if(ls.size()>0){
            while(in.size()>0){
                if(ls.size()==0){
                    return false;
                }
                int i = in.pop();
                if(i>ls.get(ls.size()-1)){
                    return false;
                }
                ls.remove(ls.size() - 1);
            }
        }
        else{
            return false;
        }
      } 
      return true; 
    }
}
