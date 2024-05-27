class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1){
            return -1;
        }
        
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while (!q.isEmpty()){
            int[] coord = q.poll();
            int r = coord[0];
            int c = coord[1];
            int length = coord[2];

            if (Math.min(r,c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == 1){
                continue;
            }

            if (r == ROWS - 1 && c == COLS - 1){
                return length;
            }

            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
            for (int[] d : dirs){
                int newRow = r + d[0];
                int newCol = c + d[1];

                if (Math.min(newRow, newCol) >= 0 && newRow < ROWS && newCol < COLS && visited[newRow][newCol] != true){
                    q.add(new int[]{newRow, newCol, length+1});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }
}
