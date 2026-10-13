public class Solution {
    public bool IsAnagram(string s, string t) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];

        for(int i=0; i<s.Length; i++){
            sarr[s[i]-'a']++;
        }
        for(int i=0; i<t.Length; i++){
            tarr[t[i]-'a']++;
        }

        for(int i=0; i<26; i++){
            if(sarr[i] != tarr[i]){
                return false;
            }
        }
        return true;
    }
}
