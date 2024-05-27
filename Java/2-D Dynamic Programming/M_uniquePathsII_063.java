class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROWS = obstacleGrid.length;
        int COLS = obstacleGrid[0].length;
        int finalColVal = 1;

        if (obstacleGrid[ROWS-1][COLS-1] == 1){
            return 0;
        }

        int[] prevRow = new int[COLS];
        for (int r = ROWS - 1; r >= 0; r--){
            int[] curRow = new int[COLS];
            if (obstacleGrid[r][COLS - 1] == 1){
                finalColVal = 0;
            }
            curRow[COLS - 1] = finalColVal;

            for (int c = COLS - 2; c >= 0; c--){
                if (obstacleGrid[r][c] == 1){
                    curRow[c] = 0;
                }
                else{
                    curRow[c] = curRow[c+1] + prevRow[c];
                }
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}
