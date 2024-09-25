class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Solution {
    TrieNode root = new TrieNode();
    
    public void insert(String word){
        TrieNode curNode = root;
        for (char c : word.toCharArray()){
            curNode.children.computeIfAbsent(c, k -> new TrieNode());
            curNode.children.get(c).count++;
            curNode = curNode.children.get(c);
        }
    }

    public int count(String s){
        TrieNode curNode = root;
        int sum = 0;
        for (char c : s.toCharArray()){
            sum += curNode.children.get(c).count;
            curNode = curNode.children.get(c);
        }
        return sum;
    }

    public int[] sumPrefixScores(String[] words) {
        for (String word : words){
            insert(word);
        }

        int[] scores = new int[words.length];
        for (int i = 0; i < words.length; i++){
            scores[i] = count(words[i]);
        }
        return scores;
    }
}
