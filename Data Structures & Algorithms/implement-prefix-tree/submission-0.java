class TrieNode{
    Map<Character, TrieNode> map;
    boolean endOfWord;
    public TrieNode(boolean endOfWord){
        this.endOfWord = endOfWord;
        map = new HashMap<>();
    }
}

class PrefixTree {

    TrieNode root;
    public PrefixTree() {
       root = new TrieNode(false);  
    }

    public void insert(String word) {
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
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!p.map.containsKey(c)){
                return false;
            }
            if(i==word.length()-1){
                return p.map.get(c).endOfWord;
            }
            p = p.map.get(c);
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!p.map.containsKey(c)){
                return false;
            }
            p = p.map.get(c);
        }
        return true;
    }
}

