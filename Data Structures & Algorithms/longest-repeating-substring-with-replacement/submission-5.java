class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int left = 0;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'A']++;
            int maxFreq = 0;
            for(int l: freq){
                if(l>maxFreq){
                    maxFreq = l;
                }
            }
            if(i-left+1-maxFreq >k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            else{
                max = Math.max(max, i-left+1);
            }
            
        }

        return max;
    }
}