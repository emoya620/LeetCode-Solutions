class Solution {
    // Time Complexity: O(m*n) | Space Complexity: O(m*n)
    private final int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minObstacles = new int[m][n];

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                minObstacles[r][c] = Integer.MAX_VALUE;
            }
        }

        minObstacles[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0,0});

        while (!deque.isEmpty()){
            int[] current = deque.poll();
            int obstacles = current[0], row = current[1], col = current[2];

            for (int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(isValid(grid, newRow, newCol) && minObstacles[newRow][newCol] == Integer.MAX_VALUE){
                    if (grid[newRow][newCol] == 1){
                        minObstacles[newRow][newCol] = obstacles + 1;
                        deque.addLast(new int[]{obstacles + 1, newRow, newCol});
                    }
                    else{
                        minObstacles[newRow][newCol] = obstacles;
                        deque.addFirst(new int[]{obstacles, newRow, newCol});
                    }
                }
            }
        }
        return minObstacles[m-1][n-1];
    }

    public boolean isValid(int[][] grid, int r, int c){
        return (Math.min(r,c) >= 0 && r < grid.length && c < grid[0].length);
    }
}
