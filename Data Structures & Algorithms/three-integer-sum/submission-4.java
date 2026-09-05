class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int target = 0; target<nums.length; target++){
            int curr = -1 * nums[target];
            if (target > 0 && nums[target] == nums[target - 1]) {
                continue;
            }

            int left = target + 1;
            int right = nums.length - 1;

            while (left<right){
                if(right==target){
                    right--;
                }
                if(left==target){
                    left++;
                }
                int sum = nums[left]+nums[right];
                if(sum > curr){
                    right--;
                }
                if(sum<curr){
                    left++;
                }
                if(sum==curr){
                    List<Integer> match = new ArrayList<>();
                    match.add(curr*-1);
                    match.add(nums[right]);
                    match.add(nums[left]);
                    res.add(match);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && right <nums.length-1 && nums[right]==nums[right+1]){
                        right--;
                    }
                }

            }
        }
        return res;

    }
}
