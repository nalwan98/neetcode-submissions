class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                l = Math.max(l, map.get(curr) + 1); // Move l to the right of the last occurrence
            }
            map.put(curr, i);
            max = Math.max(max, i-l+1);
        }
        return max;
    }
}
