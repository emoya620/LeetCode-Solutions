import java.util.*;

class Pair<A, B> {
    A first;
    B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public void dijkstra(long[] dist,int source, Map<Integer, List<Pair<Integer, Integer>>> adj, int n) {
        boolean[] visited = new boolean[n + 1];
        dist[source] = 0;
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.first));
        pq.offer(new Pair<>(0L, source));
        while (!pq.isEmpty()) {
            Pair<Long, Integer> current = pq.poll();
            int currentNode = current.second;
            long currentWeight = current.first;
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            for (Pair<Integer, Integer> neighbor : adj.getOrDefault(currentNode, new ArrayList<>())) {
                int neighborNode = neighbor.first;
                long edgeWeight = neighbor.second;
                long totalWeight = currentWeight + edgeWeight;
                if (totalWeight < dist[neighborNode]) {
                    dist[neighborNode] = totalWeight;
                    pq.offer(new Pair<>(totalWeight, neighborNode));
                }
            }
        }
    }

    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            map.computeIfAbsent(u, m -> new ArrayList<>()).add(new Pair<>(v, w));
            map.computeIfAbsent(v, m -> new ArrayList<>()).add(new Pair<>(u, w));
        }

        long[] result = new long[n+1];
        for (int i = 1; i <= n; i++) {
            long[] distance =  new long[n+1];
            Arrays.fill(distance,Long.MAX_VALUE);
            dijkstra(distance,i, map, n);
            long minCost = Long.MAX_VALUE;
            for (int j = 1; j < distance.length; j++) {
                if(distance[j] != Long.MAX_VALUE){
                    minCost = Math.min(minCost, appleCost[j - 1] + distance[j] * k + distance[j]);}
            }
            result[i - 1] = minCost;
        }
        return Arrays.copyOfRange(result,0,n);
    }
}
