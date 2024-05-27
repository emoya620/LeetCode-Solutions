class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        
        for (int r = 0; r + 2 < n; r++){
            for (int c = 0; c + 2 < n; c++){
                ans[r][c] = findMaxInGrid(grid, r, c);
            }
        }
        return ans;
    }

    public int findMaxInGrid(int[][] grid, int row, int col){
        int max = Integer.MIN_VALUE;
        for (int r = row; r <= row + 2; r++){
            for (int c = col; c <= col + 2; c++){
                max = Math.max(max, grid[r][c]);
            }
        }
        return max;
    }
}
