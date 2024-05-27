class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
                else if (grid[r][c] == 1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty() && fresh != 0){
            minutes++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] orange = q.poll();
                int r = orange[0], c = orange[1];

                for (int[] d : dirs){
                    int nRow = r + d[0];
                    int nCol = c + d[1];

                    if (Math.min(nRow,nCol) >= 0 && nRow < ROWS && nCol < COLS && grid[nRow][nCol] == 1){
                        grid[nRow][nCol] = 2;
                        q.offer(new int[]{nRow, nCol});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}
