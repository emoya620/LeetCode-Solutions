// Time Complexity: O((n + m) * log(n)) | Space Complexity: O(n + m)
class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        Set<Integer> markSet = new HashSet<>();
        for (int node : marked) {
            markSet.add(node);
        }

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(new int[] { edge.get(1), edge.get(2) });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { 0, s });

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[1];
            int distance = current[0];

            if (markSet.contains(node)) {
                return dist[node];
            }

            for (int[] edge : adj.get(node)) {
                int nextNode = edge[0];
                int weight = edge[1];
                int newDist = distance + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    minHeap.offer(new int[] { newDist, nextNode });
                }
            }
        }

        return -1;
    }
}
