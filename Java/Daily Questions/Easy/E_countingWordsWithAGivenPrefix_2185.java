class Solution {
    // Time Complexity: O(n * m) | Space Complexity: O(1)
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words){
            if (word.startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }
}
