class Solution {
    public int characterReplacement(String s, int k) {
       Map<Character, Integer> map = new HashMap<>();
       int l=0;
       int max = 0;
       int maxret=0;
       for(int r=0; r<s.length(); r++){
        char cur = s.charAt(r);
        map.putIfAbsent(cur, 0);
        map.put(cur, map.get(cur)+1);
        max = Math.max(map.get(cur), max);

        if(r-l+1-max<=k){
            maxret = Math.max(maxret, r-l+1);
        }
        else{
            map.put(s.charAt(l),map.get(s.charAt(l))-1);
            l++;
        }
       }
       return maxret;
    }
}