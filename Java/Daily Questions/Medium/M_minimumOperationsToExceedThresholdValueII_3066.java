// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long n : nums){
            minHeap.offer(n);
        }

        int numOperations = 0;
        while (minHeap.peek() < k){
            long x = minHeap.poll();
            long y = minHeap.poll();

            minHeap.offer(Math.min(x,y) * 2 + Math.max(x,y));
            numOperations++;
        }
        return numOperations;
    }
}
