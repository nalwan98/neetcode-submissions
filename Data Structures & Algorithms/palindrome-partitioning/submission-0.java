class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> subset = new ArrayList<>();

        helper(res, s, subset, 0);

        return res;
    }

    public void helper(List<List<String>> res, String s,
                       List<String> subset, int i) {

        if (i == s.length()) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            String cur = s.substring(i, j + 1);

            if (checkPal(cur)) {

                // choose
                subset.add(cur);

                // explore rest of string
                helper(res, s, subset, j + 1);

                // undo
                subset.remove(subset.size() - 1);
            }
        }
    }

    public boolean checkPal(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}