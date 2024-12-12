class Solution {
    // Time Complexity: O(n + (k * logn)) | Space Complexity: O(n)
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int g : gifts){
            maxHeap.offer(g);
        }

        for (int i = 0; i < k; i++){
            maxHeap.offer((int)Math.sqrt((double)maxHeap.poll()));
        }

        long ans = 0;
        while (!maxHeap.isEmpty()){
            ans += maxHeap.poll();
        }
        return ans;
    }
}
