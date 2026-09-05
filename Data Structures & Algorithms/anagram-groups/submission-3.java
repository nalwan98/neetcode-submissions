class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
       for(String str: strs){
        int[] temparr = new int[26];
        for(char a: str.toCharArray()){
            temparr[a-'a']++;
        }
        String key = Arrays.toString(temparr);

        List<String> list = map.getOrDefault(key, new ArrayList<>());
        list.add(str);
        map.put(key, list);

       }
       List<List<String>> list = new ArrayList<>(map.values());
       return list;
    }
}
