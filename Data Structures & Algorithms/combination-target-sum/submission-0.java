class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] nums, int target, List<Integer> arr, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(arr));
            return; // Ensure to return after adding to prevent further processing
        }
        if(i==nums.length || target<0){
            return;
        }
        if(target-nums[i]>=0){
            arr.add(nums[i]);
            dfs(nums, target-nums[i], arr, i);
            arr.remove(arr.size() - 1);
        }
        dfs(nums, target, arr, i+1);
    }
}
