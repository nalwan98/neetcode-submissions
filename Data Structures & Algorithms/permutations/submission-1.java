class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(res, nums, used, subset);
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> subset){
        if(nums.length == subset.size()){
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int j=0; j<nums.length; j++){
            if(used[j]){
                continue;
            }
            subset.add(nums[j]);
            used[j]=true;
            helper(res, nums, used, subset);
            used[j]=false;
            subset.removeLast();
        }

        
    }
}
