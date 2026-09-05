class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            if(isOperator(s)){
                int two = stack.pop();
                int one = stack.pop();
                if(s.equals("+")){
                    stack.push(one+two);
                }
                if(s.equals("-")){
                    stack.push(one-two);
                }
                if(s.equals("*")){
                    stack.push(one*two);
                }
                if(s.equals("/")){
                    stack.push(one/two);
                }
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }
}
