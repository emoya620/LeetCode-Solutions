class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int result = Integer.MAX_VALUE;

        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp[0].length; i++){
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                int temp = Integer.MAX_VALUE;

                for (int k = 0; k < grid[0].length; k++){
                    if (j != k){
                        temp = Math.min(temp, grid[i][j] + dp[i-1][k]);
                    }

                    dp[i][j] = temp;
                }
            }
        }

        for (int i = 0; i < grid.length; i++){
            result = Math.min(result, dp[grid.length-1][i]);
        }

        return result;
    }
}
