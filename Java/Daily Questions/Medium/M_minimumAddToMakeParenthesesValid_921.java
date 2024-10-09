class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int minAddToMakeValid(String s) {
        int numOpen = 0;
        int totalMoves = 0;
        for (int c : s.toCharArray()){
            if (numOpen == 0 && c == ')'){
                totalMoves++;
            }
            else if (numOpen > 0 && c == ')'){
                numOpen--;
            }
            else{
                numOpen++;
            }
        }
        return totalMoves + numOpen;
    }
}
