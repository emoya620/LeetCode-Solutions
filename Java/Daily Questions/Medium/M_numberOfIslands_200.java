class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == '1'){
                    dfs(r, c, grid);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    public void dfs(int r, int c, char[][] grid){
        if (Math.min(r,c) < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);
    }
}
