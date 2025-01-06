class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;
        for (int i = 0; i < n; i++){
            ans[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;

            int j = n - i - 1;
            ans[j] += movesToRight;
            ballsToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballsToRight;
        }
        return ans;
    }
}
