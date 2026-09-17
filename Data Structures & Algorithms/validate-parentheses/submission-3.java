class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c=='[' || c=='(' || c=='{'){
                stack.push(c);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(c==')'){
                if(stack.peek()!='('){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(c==']'){
                if(stack.peek()!='['){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(c=='}'){
                if(stack.peek()!='{'){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }
}

//stack is to be used as a deque 
// so initalized as Deque<Type> stack = new ArrayDeque<>();
// or Deque<Type> stack = new LinkedList<>() but it uses more memory per element than ArrayDeque due to node allocations.

// can initalize with predefined size such as 
//Deque<Integer> stack = new ArrayDeque<>(50); If you know roughly how many items your stack will hold, you can set an initial capacity to avoid internal array resizing and improve performance.

// also can be set with initial values using List.of()
// Initialize a stack and populate it with initial items
//Deque<String> stack = new ArrayDeque<>(List.of("First", "Second", "Third"));

//use pop() peek() isEmpty() and push()