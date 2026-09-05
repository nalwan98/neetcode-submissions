class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int max = 0;
        for(int n: set){
            int length = 1;
            if(!set.contains(n-1)){
                int i = n+1;
                while(set.contains(i)){
                    length++;
                    i++;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
