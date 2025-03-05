// Time Complexity: O(1) | Space Complexity: O(1)
class Solution {
    public long coloredCells(int n){
        return 1 + 2 * (n-1) * (long) n;
    }
}


// Time Complexity: O(n) | Space Complexity: O(1)
class Solution2 {
    public long coloredCells(int n) {
        long totalCells = 1;
        int additionalCells = 4;
        for (int i = 2; i <= n; i++){
            totalCells += additionalCells;
            additionalCells += 4;
        }
        return totalCells;
    }
}
