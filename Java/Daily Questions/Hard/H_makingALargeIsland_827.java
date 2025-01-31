// Time Complexity: O(n * m) | Space Complexity: O(n * m)
class DisjointSet {
    public int[] parent;
    public int[] islandSize;

    public DisjointSet(int n) {
        parent = new int[n];
        islandSize = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            islandSize[node] = 1;
        }
    }

    public int findRoot(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findRoot(parent[node]);
    }

    public void unionNodes(int nodeA, int nodeB) {
        int rootA = findRoot(nodeA);
        int rootB = findRoot(nodeB);

        if (rootA == rootB) return;

        if (islandSize[rootA] < islandSize[rootB]) {
            parent[rootA] = rootB;
            islandSize[rootB] += islandSize[rootA];
        } else {
            parent[rootB] = rootA;
            islandSize[rootA] += islandSize[rootB];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        DisjointSet ds = new DisjointSet(rows * columns);

        int[] rowDirections = { 1, -1, 0, 0 };
        int[] columnDirections = { 0, 0, 1, -1 };

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (
                int currentColumn = 0;
                currentColumn < columns;
                currentColumn++
            ) {
                if (grid[currentRow][currentColumn] == 1) {
                    int currentNode = (columns * currentRow) + currentColumn;

                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = currentRow + rowDirections[direction];
                        int neighborColumn =
                            currentColumn + columnDirections[direction];

                        if (
                            neighborRow >= 0 &&
                            neighborRow < rows &&
                            neighborColumn >= 0 &&
                            neighborColumn < columns &&
                            grid[neighborRow][neighborColumn] == 1
                        ) {
                            int neighborNode =
                                columns * neighborRow + neighborColumn;
                            ds.unionNodes(currentNode, neighborNode);
                        }
                    }
                }
            }
        }

        int maxIslandSize = 0;
        boolean hasZero = false;
        Set<Integer> uniqueRoots = new HashSet<>();

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (
                int currentColumn = 0;
                currentColumn < columns;
                currentColumn++
            ) {
                if (grid[currentRow][currentColumn] == 0) {
                    hasZero = true;
                    int currentIslandSize = 1;

                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = currentRow + rowDirections[direction];
                        int neighborColumn =
                            currentColumn + columnDirections[direction];

                        if (
                            neighborRow >= 0 &&
                            neighborRow < rows &&
                            neighborColumn >= 0 &&
                            neighborColumn < columns &&
                            grid[neighborRow][neighborColumn] == 1
                        ) {
                            int neighborNode =
                                columns * neighborRow + neighborColumn;
                            int root = ds.findRoot(neighborNode);
                            uniqueRoots.add(root);
                        }
                    }

                    for (int root : uniqueRoots) {
                        currentIslandSize += ds.islandSize[root];
                    }

                    uniqueRoots.clear();
                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        if (!hasZero) return rows * columns;

        return maxIslandSize;
    }
}
