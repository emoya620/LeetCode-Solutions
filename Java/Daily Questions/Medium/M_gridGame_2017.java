// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        for (int n : grid[0]){
            firstRowSum += n;
        }

        long secondRowSum = 0;
        long minSum = Long.MAX_VALUE;
        for (int turnIndex = 0; turnIndex < grid[0].length; turnIndex++){
            firstRowSum -= grid[0][turnIndex];
            minSum = Math.min(minSum, Math.max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][turnIndex];
        }
        return minSum;
    }
}
