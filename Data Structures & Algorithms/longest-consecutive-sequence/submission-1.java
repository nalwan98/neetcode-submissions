class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int max = 0;
        for(int i:nums){
            if(set.contains(i) && !set.contains(i-1)){
                int currsum = 0;
                int index = i;
                while(set.contains(index)){
                    currsum++;
                    index++;
                }
                max = Math.max(max, currsum);
            }
        }
        return max;
    }
}
