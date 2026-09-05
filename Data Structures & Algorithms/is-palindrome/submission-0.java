class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){

                sb.append(Character.toLowerCase(c));
                sb2.insert(0,Character.toLowerCase(c));
            }
        }
        if(sb.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }
}
