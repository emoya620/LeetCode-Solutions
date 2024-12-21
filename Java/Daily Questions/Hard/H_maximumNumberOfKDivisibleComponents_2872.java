class Solution {
    // Time Complexity: O(m + n) | Space Complexity: O(m + n)
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n < 2){
            return 1;
        }

        int componentCount = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int node1 = edge[0], node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
            inDegree[node1]++;
            inDegree[node2]++;
        }

        long[] longValues = new long[n];
        for (int i = 0; i < n; i++){
            longValues[i] = values[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < n; node++){
            if (inDegree[node] == 1){
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()){
            int curNode = queue.poll();
            inDegree[curNode]--;
            
            long addValue = 0;
            if (longValues[curNode] % k == 0){
                componentCount++;
            }
            else{
                addValue = longValues[curNode];
            }

            for (int neighborNode : graph.get(curNode)){
                if (inDegree[neighborNode] == 0){
                    continue;
                }

                inDegree[neighborNode]--;
                longValues[neighborNode] += addValue;
                if (inDegree[neighborNode] == 1){
                    queue.offer(neighborNode);
                }
            }
        }
        return componentCount;
    }
}
