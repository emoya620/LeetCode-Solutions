class Solution {
    public int countPaths(int[][] grid) {
        int[][] visit = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visit);
    }

    public int dfs(int[][] grid, int r, int c, int[][] visited){
        if (Math.min(r,c) < 0 || r >= grid.length || c >= grid[0].length
            || visited[r][c] == 1 || grid[r][c] == 1){
                return 0;
            }
        
        if (r == grid.length - 1 && c == grid[0].length - 1){
            return 1;
        }
        
        visited[r][c] = 1;
        int count = 0;

        count += dfs(grid, r+1, c, visited);
        count += dfs(grid, r-1, c, visited);
        count += dfs(grid, r, c+1, visited);
        count += dfs(grid, r, c-1, visited);
        
        visited[r][c] = 0;
        return count;
    }
}
