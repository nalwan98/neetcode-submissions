class TimeMap {

    Map<String, List<String>> vals;
    Map<String, List<Integer>> ts;
    public TimeMap() {
        vals = new HashMap<>();
        ts = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(vals.containsKey(key)){
            vals.get(key).add(value);
            ts.get(key).add(timestamp);
        }
        else{
            List<String> curval = new ArrayList<>();
            List<Integer> curts = new ArrayList<>();
            curval.add(value);
            curts.add(timestamp);
            vals.put(key, curval);
            ts.put(key, curts);
        }
    }
    
    public String get(String key, int timestamp) {
       String res = "";
        if(vals.containsKey(key)){
            int low = 0;
            int high = vals.get(key).size()-1;
            
            while(low<=high){
                int mid = low + (high-low)/2;
                if(ts.get(key).get(mid)<=timestamp){
                    res = vals.get(key).get(mid);
                    low = mid + 1;
                }
                else if(ts.get(key).get(mid)>timestamp){
                    high = mid - 1;
                }
            }
        }
        else{
            return "";
        }
        return res;
    }
}
