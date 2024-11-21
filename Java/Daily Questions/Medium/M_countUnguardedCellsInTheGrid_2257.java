class Solution {
    // Time Complexity: O(m*n + g*(m+n)) | Space Complexity: O(m*n)
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] wall : walls){
            grid[wall[0]][wall[1]] = 3;
        }

        for (int[] guard : guards){
            grid[guard[0]][guard[1]] = 2;
        }

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 2){
                    updateWatchedCells(grid, r, c, m, n);
                }
            }
        }

        int numUnguarded = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 0){
                    System.out.println(r+","+c);
                    numUnguarded++;
                }
            }
        }
        return numUnguarded;
    }

    public void updateWatchedCells(int[][] grid, int r, int c, int m, int n){
        int curRow = r+1;
        while (curRow < m && grid[curRow][c] != 3 && grid[curRow][c] != 2){
            grid[curRow][c] = 1;
            curRow++;
        }

        curRow = r-1;
        while (curRow >= 0 && grid[curRow][c] != 3 && grid[curRow][c] != 2){
            grid[curRow][c] = 1;
            curRow--;
        }

        int curCol = c+1;
        while (curCol < n && grid[r][curCol] != 3 && grid[r][curCol] != 2){
            grid[r][curCol] = 1;
            curCol++;
        }

        curCol = c-1;
        while (curCol >= 0 && grid[r][curCol] != 3 && grid[r][curCol] != 2){
            grid[r][curCol] = 1;
            curCol--;
        }
    }
}
