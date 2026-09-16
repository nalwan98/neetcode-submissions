class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0; i<s1.length(); i++){
            s1freq[s1.charAt(i)-'a']++;
            s2freq[s2.charAt(i)-'a']++;
        }
        int matching =0;
        for(int i=0; i<26; i++){
            if(s1freq[i]==s2freq[i]){
                matching++;
            }
        }
        
        int l=0;
        for(int r = s1.length(); r<s2.length(); r++){
            if(matching==26){
            return true;
            }
            
            if(s2freq[s2.charAt(l)-'a']==s1freq[s2.charAt(l)-'a']){
                matching--;
            }
            s2freq[s2.charAt(l)-'a']--;
             if(s2freq[s2.charAt(l)-'a']==s1freq[s2.charAt(l)-'a']){
                matching++;
            }
            
            if(s2freq[s2.charAt(r)-'a']==s1freq[s2.charAt(r)-'a']){
                matching--;
            }
            s2freq[s2.charAt(r)-'a']++;
            if(s2freq[s2.charAt(r)-'a']==s1freq[s2.charAt(r)-'a']){
                matching++;
            }
            l++;
        }
        return matching == 26;
    }
}
