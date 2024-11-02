class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split("\\s");

        for (int i = 1; i < words.length; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            if (word1.charAt(word1.length() - 1) != word2.charAt(0)){
                return false;
            }
        }

        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}
