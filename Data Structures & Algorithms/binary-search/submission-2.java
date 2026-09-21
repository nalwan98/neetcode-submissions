class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        int mid = low + ((high - low) >>> 1);

        while(low<=high){
            if(target==nums[mid]){
                return mid;
            }
            else if(target>nums[mid]){
                low = mid+1;

            }
            else{
                high = mid-1;
            }
            mid = low + ((high - low) >>> 1);
        }
        return -1;
    }
}
