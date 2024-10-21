class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode cur, int index){
        for (int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == '.'){
                for (TrieNode node : cur.children){
                    if (node != null && searchHelper(word, node, i+1)){
                        return true;
                    }
                }
                return false;
            }

            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
