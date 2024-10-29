// Time Complexity: O(ROWS*COLS) | Space Complexity: O(ROWS)
class Solution {
    int maximumMoves = 0;
    
    public int maxMoves(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        int[][] dp = new int[ROWS][2];
        for (int i = 0; i < ROWS; i++){
            dp[i][0] = 1;
        }

        int maxMoves = 0;
        for (int c = 1; c < COLS; c++){
            for (int r = 0; r < ROWS; r++){
                if (grid[r][c] > grid[r][c-1] && dp[r][0] > 0){
                    dp[r][1] = Math.max(dp[r][1], dp[r][0] + 1);
                }
                if (r - 1 >= 0 && grid[r][c] > grid[r-1][c-1] && dp[r-1][0] > 0){
                    dp[r][1] = Math.max(dp[r][1], dp[r-1][0] + 1);
                }
                if (r + 1 < ROWS && grid[r][c] > grid[r+1][c-1] && dp[r+1][0] > 0){
                    dp[r][1] = Math.max(dp[r][1], dp[r+1][0] + 1);
                }

                maxMoves = Math.max(maxMoves, dp[r][1] - 1);
            }

            for (int k = 0; k < ROWS; k++){
                dp[k][0] = dp[k][1];
                dp[k][1] = 0;
            }
        }
        return maxMoves;
    }
}
