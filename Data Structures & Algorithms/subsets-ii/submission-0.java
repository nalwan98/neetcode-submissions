class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(res, nums, subset, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, List<Integer> subset, int i){
        if(nums.length==i){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        helper(res, nums, subset, i+1);
        subset.removeLast();
        int j=i;
        while(j+1<nums.length && nums[j]==nums[j+1]){
            j++;
        }
         helper(res, nums, subset, j+1);
    }
}
