class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        long[] prefixSums = new long[n+1];
        for (int i = 1; i <= n; i++){
            prefixSums[i] = prefixSums[i-1] + nums[i-1];
        }

        Deque<Integer> candidateIndices = new ArrayDeque<>();
        int shortestSubarrayLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++){
            while (!candidateIndices.isEmpty() && prefixSums[i] - prefixSums[candidateIndices.peekFirst()] >= k){
                shortestSubarrayLength = Math.min(shortestSubarrayLength, i - candidateIndices.pollFirst());
            }

            while (!candidateIndices.isEmpty() && prefixSums[i] <= prefixSums[candidateIndices.peekLast()]){
                candidateIndices.pollLast();
            }
            candidateIndices.offerLast(i);
        }
        return shortestSubarrayLength == Integer.MAX_VALUE ? -1 : shortestSubarrayLength;
    }
}
