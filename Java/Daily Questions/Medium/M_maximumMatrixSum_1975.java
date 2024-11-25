class Solution {
    // Time Complexity: O(n * n) | Space Complexity: O(1)
    public long maxMatrixSum(int[][] matrix) {
        int numNegative = 0;
        long totalSum = 0;
        int minAbsVal = Integer.MAX_VALUE;
        for (int[] row : matrix){
            for (int val : row){
                if (val < 0){
                    numNegative++;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(val));
                totalSum += Math.abs(val);
            }
        }
        return (numNegative % 2 == 1) ? totalSum - (2 * minAbsVal) : totalSum;
    }
}
