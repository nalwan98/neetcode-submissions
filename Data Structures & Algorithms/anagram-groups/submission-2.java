class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String l: strs){
            char[] curr = l.toCharArray();
            Arrays.sort(curr);
            String key = new String(curr);
            if(map.containsKey(key)){
                map.get(key).add(l);
            }
            else{
                map.put(key, new ArrayList<>(Arrays.asList(l)));
            }
        }
        res.addAll(map.values());
        return res;
    }
}
