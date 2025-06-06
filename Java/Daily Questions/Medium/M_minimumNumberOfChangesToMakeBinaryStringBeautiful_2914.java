class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int minChanges(String s) {
        int minChanges = 0;

        for (int i = 0; i < s.length(); i += 2){
            if (s.charAt(i) != s.charAt(i+1)){
                minChanges++;
            }
        }
        return minChanges;
    }
}
