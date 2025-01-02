class Solution {
    // Time Complexity: O(N + L) | Space Complexity: O(L)
    public String stringShift(String s, int[][] shift) {
        int leftShifts = 0;
        for (int[] move : shift) {
            if (move[0] == 1) {
                move[1] = -move[1];
            }
            leftShifts += move[1];
        }

        leftShifts = Math.floorMod(leftShifts, s.length());
        s = s.substring(leftShifts) + s.substring(0, leftShifts);
        return s;
    }
}
