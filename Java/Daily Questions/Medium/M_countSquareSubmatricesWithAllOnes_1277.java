class Solution {
    public int countSquares(int[][] matrix) {
        int numSquares = 0;
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                int offset = 0;
                while (r + offset < matrix.length && c + offset < matrix[0].length && checkSquare(matrix, r, c, offset)){
                    numSquares++;
                    offset++;
                }
            }
        }
        return numSquares;
    }

    public boolean checkSquare(int[][] matrix, int startRow, int startCol, int offset){
        for (int r = startRow; r <= startRow + offset; r++){
            for (int c = startCol; c <= startCol + offset; c++){
                if (matrix[r][c] == 0){
                    return false;
                }
            }
        }
        return true;
    }
