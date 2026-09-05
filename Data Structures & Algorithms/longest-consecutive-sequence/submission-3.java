class Solution {
    public int longestConsecutive(int[] nums) {
       int max = 0;
       Set<Integer> map = new HashSet<Integer>();
       for(int i=0; i<nums.length; i++){
        map.add(nums[i]);
       }
       for(int i =0; i<nums.length; i++){
        if(map.contains(nums[i])){
            int curr = nums[i];
            int total = 0;
            while(map.contains(curr)){
                total++;
                map.remove(curr);
                curr = curr-1;
            }
            curr = nums[i]+1;
            while(map.contains(curr)){
                total++;
                map.remove(curr);
                curr = curr+1;
            }
            max = Math.max(max, total);
        }
       } 
       return max;
    }
}
