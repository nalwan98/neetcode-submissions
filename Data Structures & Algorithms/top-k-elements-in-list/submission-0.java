class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }

        List<Integer>[] arroflist = new List[nums.length + 1];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (arroflist[entry.getValue()] == null) {
                arroflist[entry.getValue()] = new ArrayList<>();
            }
             arroflist[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int j=0;
        for(int i=arroflist.length-1; i>=1; i--){
            if(arroflist[i]!=null){
                for(int s: arroflist[i]){
                    if(j<k){
                        res[j]=s;
                        j++;
                    }
                    else{
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
