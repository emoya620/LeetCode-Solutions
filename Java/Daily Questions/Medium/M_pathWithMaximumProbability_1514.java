class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        dist[start_node] = 1.0;
        for (int i = 0; i < n-1; i++){
            boolean updated = false;
            for (int j = 0; j < edges.length; j++){
                int a = edges[j][0];
                int b = edges[j][1];
                double probability = succProb[j];

                if (dist[a] * probability > dist[b]){
                    dist[b] = dist[a] * probability;
                    updated = true;
                }
                if (dist[b] * probability > dist[a]){
                    dist[a] = dist[b] * probability;
                    updated = true;
                }
            }
            
            if (!updated){
                break;
            }
        }
        return dist[end_node];
    }
}
