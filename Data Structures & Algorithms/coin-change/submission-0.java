class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Fill the array with 1s
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;

        for(int i=1; i< amount+1; i++){
            for(int c: coins){
                if(i-c>=0){
                    dp[i] = Math.min(dp[i], 1 + dp[i-c]);
                }
            }
        }
        if(dp[amount] != amount+1){
            return dp[amount];
        }
        return -1;
    }
}
