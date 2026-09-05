class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(str, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
