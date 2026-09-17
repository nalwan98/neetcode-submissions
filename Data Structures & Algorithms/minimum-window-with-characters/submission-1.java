class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> matchingmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int matching = 0;
        String res = "";

        for (int r = 0; r < s.length(); r++) {

            char rightchar = s.charAt(r);

            // ADD RIGHT
            if (tmap.containsKey(rightchar)) {

                if (matchingmap.getOrDefault(rightchar, 0)
                        == tmap.get(rightchar) - 1) {
                    matching++;
                }

                matchingmap.put(
                    rightchar,
                    matchingmap.getOrDefault(rightchar, 0) + 1
                );
            }

            // SHRINK LEFT
            while (matching == tmap.size()) {

                // save result
                if (res.isEmpty() || res.length() > r - l + 1) {
                    res = s.substring(l, r + 1);
                }

                char leftchar = s.charAt(l);

                if (tmap.containsKey(leftchar)) {

                    matchingmap.put(
                        leftchar,
                        matchingmap.get(leftchar) - 1
                    );

                    if (matchingmap.get(leftchar) < tmap.get(leftchar)) {
                        matching--;
                    }
                }

                l++;
            }
        }

        return res;
    }
}