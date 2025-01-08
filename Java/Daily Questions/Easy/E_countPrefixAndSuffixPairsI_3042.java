class Solution {
    // Time Complexity: O(n^2 * m) | Space Complexity: O(n * m)
    class TrieNode{
        Map<Character, TrieNode> children;

        public TrieNode(){
            this.children = new HashMap<>();
        }
    }
    
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++){
            TrieNode prefixTrie = new TrieNode();
            TrieNode suffixTrie = new TrieNode();

            insert(prefixTrie, words[i]);

            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            insert(suffixTrie, reversedWord);

            for (int j = 0; j < i; j++){
                if (words[j].length() > words[i].length()) continue;

                String prefix = words[j];
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (startsWith(prefixTrie, prefix) && startsWith(suffixTrie, reversedPrefix)){
                    count++;
                }
            }
        }
        return count;
    }

    public void insert(TrieNode root, String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
    }

    public boolean startsWith(TrieNode root, String prefix){
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            if (!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}
