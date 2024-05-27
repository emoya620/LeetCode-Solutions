class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for (int r = m-1; r >= 0; r--){
            int[] curRow = new int[n];
            curRow[n-1] = 1;
            for (int c = n-2; c >= 0; c--){
                curRow[c] = prevRow[c] + curRow[c+1];
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}
