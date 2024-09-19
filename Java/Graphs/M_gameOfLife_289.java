class Solution {
    // Time Complexity: O(m * n) | Space Complexity: O(1)
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] directions = new int[][]{{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        
        // O(8 * m * n)
        for (int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int numLive = 0;
                if (board[r][c] == 0){
                    for (int[] dir : directions){
                        int newR = r + dir[0];
                        int newC = c + dir[1];

                        if (Math.min(newR, newC) >= 0 && newR < m && newC < n && (board[newR][newC] == 1 || board[newR][newC] == 3)){
                            numLive++;
                        }
                    }
                    
                    if (numLive == 3){
                        board[r][c] = 2;
                    }
                }
                else if (board[r][c] == 1){
                    for (int[] dir : directions){
                        int newR = r + dir[0];
                        int newC = c + dir[1];

                        if (Math.min(newR, newC) >= 0 && newR < m && newC < n && (board[newR][newC] == 1 || board[newR][newC] == 3)){
                            numLive++;
                        }
                    }
                    
                    if (numLive < 2 || numLive > 3){
                        board[r][c] = 3;
                    }
                }
            }
        }

        // O(m*n)
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == 2){
                    board[r][c] = 1;
                }
                else if (board[r][c] == 3){
                    board[r][c] = 0;
                }
            }
        }
    }
}
