class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int current = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){

            }
            else{
            current = nums[i];
            int left = i+1;
            int right = nums.length -1;
            while(left<right){
                int cursum= nums[left] + nums[right];
                if(cursum> 0-nums[i]){
                    right--;
                }
                else if(cursum<0-nums[i]){
                    left++;
                }
                else{
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    res.add(l);
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
            }
            }
        }
        return res;
    }
}
