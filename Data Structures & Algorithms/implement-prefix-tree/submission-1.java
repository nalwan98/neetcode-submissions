class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode(false);
    }

    public void insert(String word) {
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
        TrieNode cur = root;
        int i = 0;

        // FIX: Changed word.length to word.length()
        while (i < word.length() &&
               cur.getChildren().containsKey(word.charAt(i))) {
            cur = cur.getChildren().get(word.charAt(i));
            i++;
        }

        if (i < word.length()) { // FIX: Added ()
            return false;
        }

        // FIX: Changed cur.isend to cur.isend()
        return cur.isend();
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int i = 0;

        // FIX: Changed word to prefix and added length()
        while (i < prefix.length() &&
               cur.getChildren().containsKey(prefix.charAt(i))) {
            cur = cur.getChildren().get(prefix.charAt(i));
            i++;
        }

        // FIX: Changed word to prefix and added length()
        if (i < prefix.length()) {
            return false;
        }

        return true;
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
