class Solution {
    int[] rows = {1, -1, 0, 0};
    int[] cols = {0, 0, -1, 1};
    int maxGold = 0;
    
    public int getMaximumGold(int[][] grid) {
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] != 0){
                    maxGold = Math.max(maxGold, dfs(grid, r, c));
                }
            }
        }
        return maxGold;
    }

    public int dfs(int[][] grid, int r, int c){
        if (Math.min(r,c) < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0){
            return 0;
        }

        int cur = grid[r][c];
        grid[r][c] = 0;
        int localMax = cur;
        
        for (int i = 0; i < 4; i++){
            int newRow = r + rows[i];
            int newCol = c + cols[i];
            localMax = Math.max(localMax, cur + dfs(grid, newRow, newCol));
        }
        grid[r][c] = cur;
        return localMax;
    }
}
