class Solution {
    boolean isSubIsland = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        for (int r = 0; r < grid2.length; r++){
            for (int c = 0; c < grid2[0].length; c++){
                if (grid2[r][c] == 1){
                    dfs(grid1, grid2, r, c);
                    if (isSubIsland){
                        subIslands++;
                    }
                    isSubIsland = true;
                }
            }
        }
        return subIslands;
    }

    public void dfs(int[][] grid1, int[][] grid2, int r, int c){
        if (Math.min(r,c) < 0 || r >= grid2.length || c >= grid2[0].length || grid2[r][c] == 0){
            return;
        }

        if (grid1[r][c] == 0){
            isSubIsland = false;
        }

        grid2[r][c] = 0;
        dfs(grid1, grid2, r+1, c);
        dfs(grid1, grid2, r, c+1);
        dfs(grid1, grid2, r-1, c);
        dfs(grid1, grid2, r, c-1);
    }
}
