class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()){
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            char c2 = s2.charAt(i);
            s1count[c-'a']++;
            s2count[c2-'a']++;
        }
        // Check if the first window matches
        if (Arrays.equals(s1count, s2count)) {
            return true;
        }
        
        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            s2count[s2.charAt(i - s1.length()) - 'a']--; // Remove the leftmost character
            s2count[s2.charAt(i) - 'a']++; // Add the new character
            
            // Check for match
            if (Arrays.equals(s1count, s2count)) {
                return true;
            }
        }
        return false;
    }
}
