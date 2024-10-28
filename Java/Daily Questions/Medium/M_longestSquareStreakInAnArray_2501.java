class Solution {
    // Time Complexity: O(n^2) | Space Complexity: O(n);
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int n : nums){
            numSet.add(n);
        }

        int maxStreak = -1;
        for (int n : nums){
            int streak = 1;
            double curNum = (double) n;
            while (Math.sqrt(curNum) == Math.rint(Math.sqrt(curNum)) && numSet.contains((int) Math.sqrt(curNum))){
                System.out.println(n + " " + Math.sqrt(n % 1));
                curNum = Math.sqrt(curNum);
                streak++;
                maxStreak = Math.max(maxStreak, streak);
            }
        }
        return maxStreak;
    }
}
