class Solution {
    // Time Complexity: O(n * logn) | Space Complexity: O(n)
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        int maxVal = 0, maxSum = 0;
        for (int[] e : events){
            while (!pq.isEmpty() && pq.peek().getKey() < e[0]){
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }

            maxSum = Math.max(maxSum, maxVal + e[2]);
            pq.add(new Pair<>(e[1],e[2]));
        }
        return maxSum;
    }
}
