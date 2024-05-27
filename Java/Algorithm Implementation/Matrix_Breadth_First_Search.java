class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0});

        boolean[][] visited = new boolean[ROWS][COLS];
        visited[0][0] = true;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int len = cur[2];

            if (Math.min(r,c) < 0 || r == ROWS || c == COLS || grid[r][c] == 1){
                continue;
            }

            if (r == ROWS - 1 && c == COLS - 1){
                return len;
            }

            for (int[] d : dirs){
                int nRow = r + d[0];
                int nCol = c + d[1];

                if (Math.min(nRow, nCol) >= 0 && nRow < ROWS && nCol < COLS && visited[nRow][nCol] != true && grid[nRow][nCol] != 1){
                    q.add(new int[]{nRow, nCol, len+1});
                    visited[nRow][nCol] = true;
                }
            }
        }
        return -1;
    }
}
