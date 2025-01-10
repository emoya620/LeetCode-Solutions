class Solution {
    // Time Complexity: O(n + m) | Space Complexity: O(n + m)
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxSubset = count("");
        for (String w2 : words2){
            int[] w2Count= count(w2);
            for (int i = 0; i < 26; i++){
                maxSubset[i] = Math.max(maxSubset[i], w2Count[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        search: for(String w1 : words1){
            int[] w1Count = count(w1);
            for (int i = 0; i < 26; i++){
                if (w1Count[i] < maxSubset[i]){
                    continue search;
                }
            }
            ans.add(w1);
        }

        return ans;
    }

    public int[] count(String word){
        int[] ans = new int[26];
        for (char c : word.toCharArray()){
            ans[c - 'a']++;
        }
        return ans;
    }
}
