class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minstack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(!stack.isEmpty()){
            if (val<minstack.peek()){
                minstack.push(val);
            }
            else{
                minstack.push(minstack.peek());
            }
        }
        else{
            minstack.push(val);
        }
        stack.push(val);
        
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
