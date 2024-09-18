class Solution {
    HashMap<String, List<String>> prefixMap = new HashMap<>();
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> answer = new ArrayList<>();
        createPrefixMap(words);
        for (int i = 0; i < words.length; i++){
            List<String> wordList = new ArrayList<>();
            wordList.add(words[i]);
            backtracking(1, wordList, answer, words[i].length());
        }
        return answer;
    }

    public void backtracking(int step, List<String> words, List<List<String>> ans, int n){
        if (words.size() == n){
            ans.add(new ArrayList<>(words));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words){
            sb.append(word.charAt(step));
        }

        String prefix = sb.toString();
        List<String> wordList = prefixMap.getOrDefault(prefix, new ArrayList<>());
        for (String word : wordList){
            words.add(word);
            backtracking(step+1, words, ans, n);
            words.remove(words.size() - 1);
        }
    }

    public void createPrefixMap(String[] words){
        for (String word : words){
            for (int i = 0; i < word.length(); i++){
                String prefix = word.substring(0, i);
                prefixMap.putIfAbsent(prefix, new ArrayList<>());
                List<String> list = prefixMap.get(prefix);
                list.add(word);
            }
        }
    }
}
