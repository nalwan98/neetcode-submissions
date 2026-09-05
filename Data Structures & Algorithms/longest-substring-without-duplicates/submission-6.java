class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int curloc = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for(int i=1; i<s.length(); i++){
            char a = s.charAt(i);
            if(map.containsKey(a)){
                curloc = Math.max(map.get(a)+1, curloc);
            }
                map.put(a, i);
                max = Math.max(max, i-curloc+1);
        }
        return max;
    }
}
