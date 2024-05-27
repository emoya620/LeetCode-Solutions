class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--){
            for (int x = text2.length() - 1; x >= 0; x--){
                if (text1.charAt(i) == text2.charAt(x)){
                    dp[i][x] = 1 + dp[i+1][x+1];
                }
                else{
                    dp[i][x] = Math.max(dp[i+1][x], dp[i][x+1]);
                }
            }
        }
        return dp[0][0];
    }
}
