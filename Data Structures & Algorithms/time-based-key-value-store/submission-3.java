class TimeMap {

    Map<String, List<String>> vals;
    Map<String, List<Integer>> ts;
    public TimeMap() {
        vals= new HashMap<>();
        ts = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        vals.put(key, vals.getOrDefault(key, new ArrayList<>()));
        vals.get(key).add(value);
        ts.put(key, ts.getOrDefault(key, new ArrayList<>()));
        ts.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!vals.containsKey(key)){
            return "";
        }
        String res = "";
        List<Integer> listTs = ts.get(key);
        int low = 0;
        int high = listTs.size()-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(listTs.get(mid)<timestamp){
                res = vals.get(key).get(mid);
                low = mid+1;
            }
            else if(listTs.get(mid)>timestamp){
                high = mid-1;
            }
            else{
                return vals.get(key).get(mid);
            }
        }
        return res;
    }
}
