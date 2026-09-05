class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for(int num: nums){
            if(!set.contains(num)){
                continue;
            }

            int total = 1;
            int curr = num-1;
            //expandleft
            while(set.contains(curr)){
                total++;
                set.remove(curr);
                curr--;
            }

            //expandright
            curr = num+1;
            while(set.contains(curr)){
                total++;
                set.remove(curr);
                curr++;
                
            }
            set.remove(num);
            max = Math.max(max, total);
        }
        
        return max;
    }
}