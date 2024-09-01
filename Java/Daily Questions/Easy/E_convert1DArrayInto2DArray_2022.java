class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length){
            return new int[][]{};
        }

        int[][] ans = new int[m][n];
        int index = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                ans[r][c] = original[index];
                index++;
            }
        }
        return ans;
    }
}
