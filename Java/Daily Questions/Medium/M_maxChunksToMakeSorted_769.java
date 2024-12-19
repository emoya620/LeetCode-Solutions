class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0, maxElement = 0;

        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            if (maxElement == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
