class TrieNode{
    Map<Character, TrieNode> map;
    boolean endOfWord;
    public TrieNode(boolean endOfWord){
        this.endOfWord = endOfWord;
        map = new HashMap<>();
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode(false);
    }

    public void addWord(String word) {
        TrieNode p = root;
        int i;
        for(i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(p.map.containsKey(c)){
            }
            else{
                TrieNode addc = new TrieNode(false);
                p.map.put(c, addc);
            }
            if(i==word.length()-1){
                p.map.get(c).endOfWord = true;
            }
            p = p.map.get(c);
        }
    }

    public boolean search(String word) {
        TrieNode p = root;
        return dfs(word, p);
    }

    private boolean dfs(String word, TrieNode p){
        if(word.length()==0){
            return p.endOfWord;
        }

        if(p.map.containsKey(word.charAt(0))){
            return dfs(word.substring(1, word.length()), p.map.get(word.charAt(0)));
        }
        if(word.charAt(0) == '.'){
            boolean check = false;
            for(TrieNode q: p.map.values()){
                check = check || dfs(word.substring(1, word.length()), q);
            }
            return check;
        }
        return false;
    }
}


