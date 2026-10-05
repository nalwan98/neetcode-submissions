class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, candidates, target, 0, subset);
        return res;
    }
    public void helper(List<List<Integer>> res, int[] candidates, int target, int i, List<Integer> subset){
        if(target==0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(candidates.length == i){
            return;
        }
        int j=i;
         while(j+1<candidates.length && candidates[j]== candidates[j+1]){
                j++;
            }
        if(target>= candidates[i]){
            subset.add(candidates[i]);
            helper(res, candidates, target-candidates[i], i+1, subset);
            subset.removeLast();
        }
        helper(res, candidates, target, j+1, subset);
    }
}
