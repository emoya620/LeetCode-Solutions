class Solution {
    // Time Complexity: O(n + m) | Space Complexity: O(n)
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArr = new int[n];

        for (int[] shift : shifts){
            if (shift[2] == 1){
                diffArr[shift[0]]++;
                if (shift[1] + 1 < n){
                    diffArr[shift[1] + 1]--;
                }
            }
            else{
                diffArr[shift[0]]--;
                if (shift[1] + 1 < n) {
                    diffArr[shift[1] + 1]++;
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int numShifts = 0;
        for (int i = 0; i < n; i++){
            numShifts = (numShifts + diffArr[i]) % 26;
            if (numShifts < 0){
                numShifts += 26;
            }

            char shiftedChar = (char) ('a' + ((s.charAt(i) - 'a' + numShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }
        return result.toString();
    }
}
