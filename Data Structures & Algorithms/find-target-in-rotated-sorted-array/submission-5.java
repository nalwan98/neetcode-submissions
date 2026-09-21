class Solution {
    public int search(int[] nums, int target) {
        int low= 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low + ((high - low) >>> 1);
            if(target == nums[mid]){
                return mid;
            }
            //is Left side sorted
            else if (nums[low] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if (nums[high]>=nums[mid]){
                if(target <= nums[high] && target >= nums[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }    
             
        }
        return -1;

    }
}
