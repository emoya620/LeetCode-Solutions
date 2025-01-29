// Time Complexity: O(N + E) | Space Complexity: O(N + E)
class Solution {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1){
            return false;
        }

        for (int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && seen.size() == n;
    }

    public boolean dfs(int node, int parent){
        if (seen.contains(node)){
            return false;
        }

        seen.add(node);
        for (int neighbor : adjacencyList.get(node)){
            if (parent != neighbor){
                if (!dfs(neighbor, node)){
                    return false;
                }
            }
        }
        return true;
    }
}
