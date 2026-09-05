class Solution {
    public boolean isAnagram(String s, String t) {
        int[] checks = new int[26];
        int[] checkt = new int[26];
        for(char i: s.toCharArray()){
            checks[i-'a']++;
        }
        for(char i: t.toCharArray()){
            checkt[i-'a']++;
        }
        for(int i=0; i<26; i++){
            if(checks[i]!=checkt[i]){
                return false;
            }
        }
        return true;
    }
}
