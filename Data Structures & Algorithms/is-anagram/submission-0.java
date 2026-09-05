class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c: t.toCharArray()){
            arr2[c-'a']++;
        }
        for(int i=0; i< arr.length; i++){
            if(arr[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
