class Solution {
    // Time Complexity: O(m + n) | Space Complexity: O(m)
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int b : banned){
            bannedSet.add(b);
        }

        int curSum = 0;
        int numMoves = 0;
        for (int i = 1; i <= n; i++){
            if (curSum + i > maxSum){
                return numMoves;
            }

            if (!bannedSet.contains(i)){
                curSum += i;
                numMoves++;
            }
        }
        return numMoves;
    }
}
