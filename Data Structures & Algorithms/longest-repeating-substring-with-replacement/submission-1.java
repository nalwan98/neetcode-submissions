class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxCount = 0; // Keep track of the max frequency of a single character
        int maxLength = 0;

        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            maxCount = Math.max(maxCount, map.get(curr)); // Update max count

            // Current window size is (r - l + 1), and we need to check if we can replace
            if (r - l + 1 - maxCount > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1); // Update max length
        }

        return maxLength;
    }
}
