class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int curnum = prices[0];
        for(int i=1; i<prices.length; i++){
            maxprofit = Math.max(maxprofit, prices[i]-curnum);
            curnum = Math.min(curnum, prices[i]);
        }
        return maxprofit;
    }
}
