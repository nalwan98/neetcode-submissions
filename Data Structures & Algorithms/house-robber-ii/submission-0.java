class Solution {
    public int rob(int[] nums) {
         if (nums.length == 1) return nums[0]; // Edge case for only one house
        return Math.max(hopper1 (nums, 0, nums.length-2), hopper1 (nums, 1, nums.length-1));
    }
    private int hopper1 (int[] nums, int start, int end){
        int[] dp = new int[end-start + 3];
        dp[0] = 0;
        dp[1] = 0;
        int j = start;
        for(int i =2; i< dp.length; i++){
            dp[i] = Math.max(nums[j] + dp[i-2], dp[i-1]);
            j++;
        }

        return dp[end-start + 2];
    }
}
