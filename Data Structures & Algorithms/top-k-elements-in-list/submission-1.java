class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        List<Integer>[] arroflist = new List[nums.length + 1];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (arroflist[entry.getValue()] == null) {
                arroflist[entry.getValue()] = new ArrayList<>();
            }
             arroflist[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int j = 0;
        for(int i= arroflist.length-1; i>=0; i--){
            List<Integer> bucket = arroflist[i];
            if(bucket!=null){
                for(int m =0; m<bucket.size(); m++){
                if(j==k){
                    return res;
                }
                res[j] = bucket.get(m);
                j++;

            }
            }
        }
        return res;
    }
}
