class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        int len = s.length();
        
        for(int i = len-1; i >= 0; i--){
            char curChar = s.charAt(i);
            int index = curChar - 'a';
            int max  = Integer.MIN_VALUE;
            
            int left = Math.max((index-k), 0);
            int right = Math.min((index+k), 26);
            
            for(int j = left; j <= right; j++){
                max = Math.max(max, dp[j]);
            }
            
            dp[index] = max+1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int val : dp){
            max = Math.max(val, max);
        }
        
        return max;
    }
}
