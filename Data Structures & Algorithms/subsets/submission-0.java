class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        subs(nums, new ArrayList<>() ,0);
        return res;
    }

    private void subs(int[] nums, List<Integer> arr, int i){
        if (i == nums.length) {
            res.add(new ArrayList<>(arr)); // Add current subset to results
            return;
        }
        
        // Include the current element
        arr.add(nums[i]);
        subs(nums, arr, i + 1); // Recurse with the current element included
        
        // Exclude the current element (backtrack)
        arr.remove(arr.size() - 1);
        subs(nums, arr, i + 1); // Recurse without the current element
    }
}
