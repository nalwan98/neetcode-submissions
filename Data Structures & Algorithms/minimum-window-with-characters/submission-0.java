class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        
        // Edge case: if s is shorter than t
        if (s.length() < t.length()) {
            return "";
        }

        // Count characters in t
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            countT.put(curr, countT.getOrDefault(curr, 0) + 1);
        }

        int l = 0, match = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            // If curr is a character in t
            if (countT.containsKey(curr)) {
                if (countT.get(curr) > 0) {
                    match++;
                }
                countT.put(curr, countT.get(curr) - 1);
            }

            // When we have a valid window
            while (match == t.length()) {
                if (res.isEmpty() || (r - l + 1 < minLen)) {
                    minLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                // Move left pointer to try and reduce window size
                char leftChar = s.charAt(l);
                if (countT.containsKey(leftChar)) {
                    countT.put(leftChar, countT.get(leftChar) + 1);
                    if (countT.get(leftChar) > 0) {
                        match--;
                    }
                }
                l++;
            }
        }
        return res;
    }
}
