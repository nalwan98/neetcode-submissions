class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i; // Start of the length
            while (str.charAt(j) != '#') {
                j++;
            }
            // Get the length of the next string
            int len = Integer.parseInt(str.substring(i, j));
            // Move past the '#' character
            i = j + 1;
            // Add the substring of the given length
            res.add(str.substring(i, i + len));
            // Move the index forward by the length of the string
            i += len;
        }
        
        return res;
    }
}
