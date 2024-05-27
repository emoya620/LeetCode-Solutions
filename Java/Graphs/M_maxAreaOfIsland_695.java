class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == 1){
                    int size = dfs(grid, r, c) + 1;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    public int dfs(int[][] grid, int r, int c){
        if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return -1;
        }

        grid[r][c] = 0;
        int size = 0;
        size += dfs(grid, r+1, c) + 1;
        size += dfs(grid, r-1, c) + 1;
        size += dfs(grid, r, c+1) + 1;
        size += dfs(grid, r, c-1) + 1;
        
        return size;
    }
}
