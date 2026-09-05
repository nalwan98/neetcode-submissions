class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        if(s.length()<=1){
            return s.length();
        }
        int max = 1;
        int l = 0;
        int r = 1;
        set.add(s.charAt(0));
        while(l<r && r<s.length()){
            char cur = s.charAt(r);
            if(set.contains(cur)){
                set.clear();
                l++;
                r = l+1;
                set.add(s.charAt(l));
            }
            else{
                max = Math.max(max, r-l+1);
                set.add(cur);
                r++;
            }
        }
        return max;
    }
}
