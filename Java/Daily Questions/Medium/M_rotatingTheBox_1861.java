class Solution {
    // Time Complexity: O(m * n^2) | Space Complexity: O(m * n)
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        int left = n-1;
        int nextAvailable;
        for (char[] row : box){
            while (left >= 0){
                while (left >= 0 && row[left] != '#'){
                    left--;
                }

                if (left == -1){
                    break;
                }

                nextAvailable = left;

                while (nextAvailable < n-1 && row[nextAvailable+1] == '.'){
                    nextAvailable++;
                }

                row[left] = '.';
                row[nextAvailable] = '#';
                left--;
            }
            left = n-1;
        }

        char[][] rotatedBox = new char[n][m];
        int row = m-1;
        int col = 0;
        for (int r = 0; r < n; r++){
            for (int c = 0; c < m; c++){
                rotatedBox[r][c] = box[row][col];
                row--;
            }
            row = m-1;
            col++;
        }
        return rotatedBox;
    }
}
