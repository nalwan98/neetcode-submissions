class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> end = new HashMap<>();
        for(int j = s.length() - 1;j>=0; j--){
            char c = s.charAt(j);
            if(!end.containsKey(c)){
                end.put(c, j);
            }
        }
        List<Integer> list = new ArrayList<>();
        int j = -1;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            j = Math.max(j, end.get(s.charAt(i)));

            if(i==j){
                list.add(i-start + 1);
                j = -1;
                start = i+1;
            }
        }
        return list;

    
    }
}
