class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] == word.charAt(0)){
                    if (wordExists(board, word, r, c, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean wordExists(char[][] board, String word, int row, int col, int index){
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }

        if (index == word.length()){
            return true;
        }

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            char oldChar = board[row][col];
            board[row][col] = '0';
            if (Math.min(newRow, newCol) >= 0 && newRow < board.length && newCol < board[0].length 
                && board[newRow][newCol] != '0' && board[newRow][newCol] == word.charAt(index)){
                if (wordExists(board, word, newRow, newCol, index+1)){
                    return true;
                }
            }
            board[row][col] = oldChar;
        }
        return false;
    }
}
