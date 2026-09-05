class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer[]> stack = new Stack<>();
        Integer[] first = new Integer[2];
        first[0] = temperatures[0];
        first[1] = 0;
        int[] res = new int[temperatures.length];
        stack.push(first);
        for(int i=1; i<temperatures.length; i++){
            while(!stack.isEmpty() && (temperatures[i]>stack.peek()[0])){
                res[stack.peek()[1]] = i-stack.peek()[1];
                stack.pop();
            }
            Integer[] add = new Integer[2];
            add[0] = temperatures[i];
            add[1] = i;
            stack.push(add);
        }

        return res;
    }
}
