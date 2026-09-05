class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new HashSet<>(), new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, Set<Integer> dont, List<Integer> arr){
        if(i==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int n=0; n<nums.length; n++){
            if(!dont.contains(n)){
                arr.add(nums[n]);
                dont.add(n);
                dfs(nums, i+1, dont, arr);
                dont.remove(n);
                arr.remove(arr.size()-1);
            }
        }
    }
}
