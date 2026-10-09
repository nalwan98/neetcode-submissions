class WordDictionary {
     TrieNode root;
    public WordDictionary() {
        root = new TrieNode(false);
    }

    public void addWord(String word) {
         TrieNode cur = root;
        int i = 0;

        // FIX: Added i < word.length() to avoid IndexOutOfBoundsException
        while (i < word.length() &&
               cur.getChildren().containsKey(word.charAt(i))) {
            cur = cur.getChildren().get(word.charAt(i));
            i++;
        }

        while (i < word.length()) {
            TrieNode newtree;

            if (i == word.length() - 1) {
                newtree = new TrieNode(true);
            } else {
                newtree = new TrieNode(false);
            }

            cur.add(word.charAt(i), newtree);
            cur = cur.getChildren().get(word.charAt(i));
            i++;
        }

        // FIX: Mark the last node as end of word even if it already existed
        // Example: insert("apple"), then insert("app")
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return search1(word, root);
    }
    public boolean search1(String word, TrieNode cur) {
        int i = 0;
        while (i < word.length()) {
            if(cur.getChildren().containsKey(word.charAt(i))){
                 cur = cur.getChildren().get(word.charAt(i));
                i++;
            }
            else if(word.charAt(i) == '.'){
                for(char j: cur.getChildren().keySet()){
                    if(search1(word.substring(i+1), cur.getChildren().get(j))){
                        return true;
                    }
                }
                return false;
            }
            else{
                return false;
            }
           
        }

        if (i < word.length()) { 
            return false;
        }

        return cur.isend();
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode(boolean endOfWord) {
        this.endOfWord = endOfWord;

        // FIX: Changed map to children
        children = new HashMap<>();
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isend() {
        return endOfWord;
    }

    public void add(char a, TrieNode b) {
        children.put(a, b);
    }
}
