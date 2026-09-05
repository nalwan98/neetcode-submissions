class Solution {
    public int countSubstrings(String s) {
        int count =0;

        for(int i=0; i<s.length(); i++){
            int l=i-1; 
            int r=i+1;
            count++;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l) ==s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
