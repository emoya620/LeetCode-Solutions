class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }
        
        if (edges.length == 0){
            return false;
        }
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges){
            if (graph.containsKey(edge[0])){
                List<Integer> list = graph.get(edge[0]);
                list.add(edge[1]);
                graph.put(edge[0], list);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                graph.put(edge[0], list);
            }

            if (graph.containsKey(edge[1])){
                List<Integer> list = graph.get(edge[1]);
                list.add(edge[0]);
                graph.put(edge[1], list);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                graph.put(edge[1], list);
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.get(source).size(); i++){
            queue.add(graph.get(source).get(i));
        }
        visited.add(source);

        while (!queue.isEmpty()){
            int node = queue.remove();

            if (node == destination){
                return true;
            }

            if (visited.contains(node)){
                continue;
            }
            visited.add(node);

            List<Integer> list = graph.get(node);
            for (int val : list){
                queue.add(val);
            }
        }
        return false;
    }
}
