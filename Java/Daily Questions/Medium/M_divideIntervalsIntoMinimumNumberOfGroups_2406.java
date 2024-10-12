class Solution {
    // Time Complexity: O(n + m) | Space Complexity: O(m)
    public int minGroups(int[][] intervals) {
        int[] pointToCount = new int[1000002];
        for (int[] time : intervals){
            pointToCount[time[0]]++;
            pointToCount[time[1] + 1]--;
        }

        int curConcurrent = 0;
        int maxConcurrent = 0;
        for (int n : pointToCount){
            curConcurrent += n;
            maxConcurrent = Math.max(curConcurrent, maxConcurrent);
        }
        return maxConcurrent;
    }
}
