// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    private final int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] start = { -1, -1 };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int steps = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize-- > 0) {
                int[] pos = queue.poll();

                for (int[] d : dir) {
                    int newRow = d[0] + pos[0];
                    int newCol = d[1] + pos[1];

                    if (isValid(grid, newRow, newCol)) {
                        if (grid[newRow][newCol] == '#') return steps;

                        grid[newRow][newCol] = 'X';
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isValid(char[][] grid, int row, int col) {
        return (
            row >= 0 &&
            col >= 0 &&
            row < grid.length &&
            col < grid[0].length &&
            grid[row][col] != 'X'
        );
    }
}
