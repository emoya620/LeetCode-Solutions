class Solution {
    // Time Complexity: O(N * log(N)) | Space Complexity: O(N)
    public long findScore(int[] nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1]- b[1];
        });
        for (int i = 0; i < nums.length; i++){
            minHeap.offer(new int[]{nums[i], i});
        }

        HashSet<Integer> marked = new HashSet<>();
        long ans = 0;
        while (!minHeap.isEmpty()){
            int[] value = minHeap.poll();
            if (!marked.contains(value[1])){
                ans += value[0];
                marked.add(value[1] - 1);
                marked.add(value[1] + 1);
            }
        }
        return ans;
    }
}
