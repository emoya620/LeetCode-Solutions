class Solution {
    // Time Complexity: O(m^2 * n^2) | Space Complexity: O(m * n)
    public List<String> stringMatching(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            for (int j = 0; j < words.length; j++){
                if (i == j){
                    continue;
                }

                if (word.contains(words[j]) && !ans.contains(words[j])){
                    ans.add(words[j]);
                }
            }
        }
        return ans;
    }
}
