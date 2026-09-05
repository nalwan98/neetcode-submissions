class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> s = new Stack<>();
       int[] res = new int[temperatures.length];
       for(int i=0; i<temperatures.length; i++){
        while(s.size()>0 && temperatures[s.peek()]<temperatures[i]){
            int t = s.pop();
            res[t] = i-t;
        }
        s.push(i);
       } 
       return res;
    }
}
