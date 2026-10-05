class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int i=0;
        List<Integer> subset = new ArrayList<>();
        helper(res, nums, target, i, subset);
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, int target, int i, List<Integer> subset){
        if (target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i==nums.length){
            return;
        }
        if(nums[i]<target){
            subset.add(nums[i]);
            helper(res, nums, target-nums[i], i, subset);
            subset.removeLast();
            helper(res, nums, target, i+1, subset);
        }
        else if(nums[i]==target){
            subset.add(nums[i]);
            helper(res, nums, target-nums[i], i+1, subset);
            subset.removeLast();
            helper(res, nums, target, i+1, subset);
        }
        else{
            helper(res, nums, target, i+1, subset);
        }
       
    }
}
