class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean found = false;
        int[] freq = new int[26];
        int[] window = new int[26];
        int left = 0;
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i = 0; i< s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
            window[s2.charAt(i)-'a']++;
        }
        int matching = 0;
         for(int i=0; i<26;i++){
            if(freq[i]==window[i]){
                matching ++;
            }
        }


        for(int r=s1.length(); r<s2.length(); r++){
             if(matching==26){
            return true;
        }
            char curr = s2.charAt(r);
            if(window[curr-'a'] == freq[curr-'a']){
                matching--;
            }
            window[curr-'a']++;
            if(window[curr-'a'] == freq[curr-'a']){
                matching++;
            }
            char remove = s2.charAt(r-s1.length());
            if(window[remove-'a'] == freq[remove-'a']){
                matching--;
            }
            window[remove-'a']--;
            if(window[remove-'a'] == freq[remove-'a']){
                matching++;
            }
        }
        return matching == 26;
    }
}
