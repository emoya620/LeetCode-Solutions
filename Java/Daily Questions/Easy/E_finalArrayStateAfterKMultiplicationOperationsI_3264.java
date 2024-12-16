class Solution {
    // Time Complexity: O(N + k * log(N)) | Space Complexity: O(N)
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            int valueComp = Integer.compare(a[0], b[0]);
            if (valueComp == 0){
                return Integer.compare(a[1], b[1]);
            }
            return valueComp;
        });

        for (int i = 0; i < nums.length; i++){
            minHeap.offer(new int[]{nums[i], i});
        }

        while (k-- > 0){
            int[] smallest = minHeap.poll();
            int index = smallest[1];

            nums[index] = smallest[0] * multiplier;
            minHeap.offer(new int[]{nums[index], index});
        }
        return nums;
    }
}
