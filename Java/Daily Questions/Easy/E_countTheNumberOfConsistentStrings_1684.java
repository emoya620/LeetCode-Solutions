class Solution {
    // Time Complexity: O(n * m) | Space Complexity: O(1)
    public int countConsistentStrings(String allowed, String[] words) {
        int[] map = new int[26];
        for (Character c : allowed.toCharArray()){
            map[c - 'a']++;
        }

        int numConsistentStrings = 0;
        for (String word : words){
            for (int i = 0; i <= word.length(); i++){
                if (i == word.length()){
                    numConsistentStrings++;
                }
                else if (map[word.charAt(i) - 'a'] == 0){
                    break;
                }
            }
        }
        return numConsistentStrings;
    }
}
