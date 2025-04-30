class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;
        
        int[][] ans = new int[n][m];
        
        for (int rowIndex = 0; rowIndex < n; ++rowIndex) {
            for (int elementIndex = 0; elementIndex < k; ++elementIndex) {
                if (mat1[rowIndex][elementIndex] != 0)  {
                    for (int colIndex = 0; colIndex < m; ++colIndex) {
                        ans[rowIndex][colIndex] += mat1[rowIndex][elementIndex] * mat2[elementIndex][colIndex];
                    }
                }
            }
        }
        
        return ans;
    }
}
