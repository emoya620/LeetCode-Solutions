class Solution {
    // Time Complexity: O(n log(n)) | Space Complexity: O(n)
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int n : nums){
            maxHeap.offer(n);
        }

        long maxScore = 0;
        while (k > 0){
            int val = maxHeap.poll();
            maxScore += val;
            maxHeap.offer((int)Math.ceil((double)val / 3));
            k--;
        }
        return maxScore;
    }
}
