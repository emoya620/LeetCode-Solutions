// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    private final int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public long sumRemoteness(int[][] grid) {
        int n = grid.length;

        UnionFind uf = new UnionFind(n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == -1) continue;

                for (int[] d : dir) {
                    int newRow = d[0] + row;
                    int newCol = d[1] + col;
                    if (isValid(grid, newRow, newCol)) {
                        uf.union(getIndex(n, row, col), getIndex(n, newRow, newCol));
                    }
                }
            }
        }

        long totalSum = 0;
        Map<Integer, Long> compSum = new HashMap<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == -1) continue;

                int parent = uf.find(getIndex(n, row, col));
                compSum.put(
                    parent,
                    compSum.getOrDefault(parent, 0L) + grid[row][col]
                );
                totalSum += grid[row][col];
            }
        }

        long result = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == -1) continue;

                long currCompSum = compSum.get(uf.find(getIndex(n, row, col)));

                result += totalSum - currCompSum;
            }
        }
        return result;
    }

    private class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n * n];
            rank = new int[n * n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }

        int find(int index) {
            if (parent[index] == -1) return index;
            return parent[index] = find(parent[index]);
        }

        void union(int idx1, int idx2) {
            int root1 = find(idx1);
            int root2 = find(idx2);

            if (root1 == root2) return;

            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    private int getIndex(int n, int row, int col) {
        return row * n + col;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        int n = grid.length;
        return (
            row >= 0 && col >= 0 && row < n && col < n && grid[row][col] != -1
        );
    }
}
