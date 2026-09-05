class Solution {
    public int[] productExceptSelf(int[] nums) {
        int all = 1;
        int[] res = new int[nums.length];
        res[0]=1;
        for(int i =1; i<nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int suf = 1;
        for(int i=nums.length-1; i>=0; i--){
            res[i] = res[i]*suf;
            suf = suf*nums[i];
        }
        return res;
    }
}  
