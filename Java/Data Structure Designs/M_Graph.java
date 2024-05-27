class Graph {
    private HashMap<Integer, HashSet<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adjList.putIfAbsent(src, new HashSet<>());
        adjList.putIfAbsent(dst, new HashSet<>());
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adjList.containsKey(src) || !adjList.containsKey(dst)){
            return false;
        }

        adjList.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(src, dst, visited);
    }

    public boolean hasPathDFS(int src, int dst, HashSet<Integer> visited){
        if (src == dst){
            return true;
        }

        visited.add(src);
        for (int n : adjList.getOrDefault(src, new HashSet<>())){
            if (!visited.contains(n)){
                if (hasPathDFS(n, dst, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
