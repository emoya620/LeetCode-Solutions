class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode(char value){
        this.val = value;
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode('0');
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
