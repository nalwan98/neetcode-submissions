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
            List<Pairs> curlist = new ArrayList<>();
            curlist.add(cur);
            map.put(key, curlist);
        }
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(!map.containsKey(key)){
            return "";
        }
        else{
            List<Pairs> curlist = map.get(key);
            int low = 0;
            int high = curlist.size() -1;
            int mid = 0;
            

            while(low<=high){
                mid = low + ((high-low) >>> 1);
                Pairs midpair = curlist.get(mid);
                Pairs lowpair = curlist.get(low);
                Pairs highpair = curlist.get(high);

                int midtime = midpair.getTime();
                int lowtime = lowpair.getTime();
                int hightime = highpair.getTime();
                if(midtime == timestamp){
                    return midpair.getValue();
                }
                else if(midtime > timestamp){
                    high = mid - 1;
                }
                else if(midtime < timestamp){
                    low = mid + 1;
                    result = midpair.getValue();
                }

            }
        }
        return result;
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
