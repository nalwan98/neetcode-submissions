class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        helper(res, digits, map, 0, "");

        return res;
    }

    public void helper(List<String> res, String digits, Map<Integer, List<Character>> map, int i, String cur){
        if(i==digits.length()){
            res.add(cur);
            return;
        }
        for(int j=0; j<map.get(digits.charAt(i)-'0').size(); j++){
            int digit = digits.charAt(i) - '0';
            cur = cur + map.get(digit).get(j);
            helper(res, digits, map, i+1, cur);
            cur = cur.substring(0, cur.length()-1);
        }
    }
}
