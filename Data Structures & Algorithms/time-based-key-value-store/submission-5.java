class TimeMap {

    private Map<String, List<Pairs>> map;
    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        Pairs cur = new Pairs(value, timestamp);
        if(map.containsKey(key)){
            map.get(key).add(cur);
        }
        else{
            List<Pairs> lis = new ArrayList<>();
            lis.add(cur);
            map.put(key, lis);
        }
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key)){
            List<Pairs> cur = map.get(key);

            int low=0;
            int high=cur.size()-1;
            int time = -1;
            while(low<=high){
                int mid = ((high-low) >>> 1) + low;
                Pairs midp = cur.get(mid);
                if(midp.getTime() == timestamp){
                    return midp.getValue();
                }
                else if(midp.getTime() > timestamp){
                    high = mid-1;
                }
                else{
                    if(time< midp.getTime()){
                        res = midp.getValue();
                        time = midp.getTime();
                    }
                    low = mid +1;
                }

            }
        }
        else{
            return "";
        }
        return res;
    }
} 

class Pairs {
    private String value;
    private int time;

    public Pairs(String val, int t){
        this.value =  val;
        this.time = t;
    }

    public String getValue(){
        return this.value;
    }
    public int getTime(){
        return this.time;
    }
}
