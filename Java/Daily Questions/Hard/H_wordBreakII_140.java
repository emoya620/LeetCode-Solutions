class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        helper(s, 0, new StringBuilder(), result, wordSet);
        return result;
    }

    public void helper(String s, int start, StringBuilder currentSentence, List<String> result, HashSet<String> wordSet){
        if (start == s.length()){
            result.add(currentSentence.toString().trim());
            return;
        }

        for (int end = start + 1; end <= s.length(); end++){
            String word = s.substring(start, end);
            if (wordSet.contains(word)){
                int curLen = currentSentence.length();
                currentSentence.append(word).append(" ");
                helper(s, end, currentSentence, result, wordSet);
                currentSentence.setLength(curLen);
            }
        }
    }
}
