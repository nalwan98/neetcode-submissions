class Solution {
    public int maxProfit(int[] prices) {
        int[] pre = new int[prices.length];
        int[] post = new int[prices.length];
        pre[0] = prices[0];
        post[prices.length-1] = prices[prices.length-1];
        for(int i=1; i<prices.length; i++){
            pre[i] = Math.min(pre[i-1] , prices[i]);
        }
        for(int i=prices.length-2; i>=0; i--){
            post[i] = Math.max(pre[i+1],prices[i]);
        }
        int max = 0;
        for(int i=0; i<prices.length; i++){
            max = Math.max(max, post[i]-pre[i]);
        }
        return max;
    }
}
