// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int cur = 2; cur < n; cur++){
            int start = 0;
            int end = cur - 1;

            while (start < end){
                int pairSum = arr[start] + arr[end];

                if (pairSum > arr[cur]){
                    end--;
                }
                else if (pairSum < arr[cur]){
                    start++;
                }
                else{
                    dp[end][cur] = dp[start][end] + 1;
                    maxLen = Math.max(dp[end][cur], maxLen);
                    end--;
                    start++;
                }
            }
        }

        return maxLen == 0 ? 0 : maxLen + 2;
    }
}
