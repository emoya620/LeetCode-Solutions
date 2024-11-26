class Solution {
    // Time Complexity: O(m * n * log(m*n)) | Space Complexity: O(m*n)
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] rows = new int[m];
        int[] cols = new int[n];
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                minHeap.offer(new int[]{grid[r][c], r, c});
            }
        }

        while (!minHeap.isEmpty()){
            int[] curVal = minHeap.poll();
            int val = Math.max(rows[curVal[1]], cols[curVal[2]]);
            grid[curVal[1]][curVal[2]] = val;
            rows[curVal[1]] = val+1;
            cols[curVal[2]] = val+1;
        }
        return grid;
    }
}
