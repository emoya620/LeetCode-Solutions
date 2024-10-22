class Solution {
    // Time Complexity: O(8^(m*n)) | Space Complexity: O(m*n)
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] board = new int[m][n];
        board[r][c] = -1;
        validTour(board, m, n, r, c, 1);
        board[r][c] = 0;
        return board;
    }

    public boolean validTour(int[][] board, int m, int n, int curRow, int curCol, int curMove){
        if (curMove == m * n){
            return true;
        }

        int[][] dirs = {{-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}};
        for (int[] dir : dirs){
            int newRow = curRow + dir[0];
            int newCol = curCol + dir[1];
            if (!isValidMove(board, m, n, curRow, curCol, newRow, newCol)){
                continue;
            }

            board[newRow][newCol] = curMove;
            if (validTour(board, m, n, newRow, newCol, curMove + 1)){
                return true;
            }
            board[newRow][newCol] = 0;
        }
        return false;
    }

    public boolean isValidMove(int[][] board, int m, int n, int fromRow, int fromCol, int toRow, int toCol){
        return (Math.min(toRow, toCol) >= 0 && toRow < m && toCol < n && Math.min(Math.abs(fromRow - toRow), Math.abs(fromCol - toCol)) == 1 && Math.max(Math.abs(fromRow - toRow), Math.abs(fromCol - toCol)) == 2 && board[toRow][toCol] == 0);
    }
}
