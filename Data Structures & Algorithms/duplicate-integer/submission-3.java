class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set check = new HashSet<Integer>();
        for(int i: nums){
            if(check.contains(i)){
                return true;
            }
            check.add(i);
        }
        return false;
    }
}