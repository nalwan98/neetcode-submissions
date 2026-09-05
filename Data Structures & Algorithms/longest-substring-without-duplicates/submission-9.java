class Solution {
    public int lengthOfLongestSubstring(String s) {
       
       Map<Character, Integer> map = new HashMap<>();
       int max = 0;
       int curleft = 0;
       for(int i=0; i<s.length(); i++){
        if(map.containsKey(s.charAt(i))){
            curleft = Math.max(curleft, map.get(s.charAt(i))+1);
        }
        max = Math.max(i-curleft+1, max);
        map.put(s.charAt(i), i);
       }
        return max;
    }
}
