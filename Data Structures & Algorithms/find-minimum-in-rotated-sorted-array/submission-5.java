class Solution {
    public int findMin(int[] nums) {
        int low=0; 
        int high = nums.length -1;

        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = ((high-low) >>> 1) + low;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            else if(nums[mid] >=nums[low]){
                low = mid+1;
            }
            else{
                high = mid;
            }
            min = Math.min(min, nums[mid]);
        }
        return min;
    }
}
