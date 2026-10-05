class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        int i =0;
        List<Integer> subset = new ArrayList<>();
        dfs(res, nums, i, subset);
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, int i, List<Integer> subset){
        if(i==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(res, nums, i+1, subset);
        subset.removeLast();
        dfs(res, nums, i+1, subset);

    }
}
