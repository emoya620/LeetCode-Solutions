class TrieNode {
    HashMap<Character, TrieNode> children;
    int count;
    int end;

    public TrieNode(){
        this.children = new HashMap<>();
        this.count = 0;
        this.end = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.count++;
        }
        cur.end++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (!cur.children.containsKey(c)){
                return 0;
            }
            cur = cur.children.get(c);
        }
        return cur.end > 0 ? cur.end : 0;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if (!cur.children.containsKey(c)){
                return 0;
            }
            cur = cur.children.get(c);
        }
        return cur.count;
    }
    
    public void erase(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children.get(c).count == 1){
                cur.children.remove(c);
                return;
            }
            cur = cur.children.get(c);
            cur.count--;
        }
        cur.end--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
