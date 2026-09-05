class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        product[0] = 1;
        for(int i =0; i<nums.length; i++){
            if(i!=0){
                product[i] = product[i-1]*nums[i-1];
            }
        }
         int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] = product[i] * suffix;
            suffix *= nums[i];
        }
        return product;
    }
}  
