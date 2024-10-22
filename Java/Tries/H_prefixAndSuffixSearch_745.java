class TrieNode {
    TrieNode[] children;
    int weight;

    public TrieNode (){
        this.children = new TrieNode[27];
        this.weight = 0;
    }
}

class WordFilter {
    TrieNode root;

    public WordFilter(String[] words) {
        this.root = new TrieNode();

        for (int weight = 0; weight < words.length; weight++){
            String word = words[weight] + '{';
            for (int i = 0; i < word.length(); i++){
                TrieNode cur = root;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; j++){
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null){
                        cur.children[k] = new TrieNode();
                    }
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        TrieNode cur = root;
        for (char c : (suff + '{' + pref).toCharArray()){
            if (cur.children[c-'a'] == null){
                return -1;
            }
            cur = cur.children[c-'a'];
        }
        return cur.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
