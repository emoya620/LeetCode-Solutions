class Solution {
    // Time Complexity: O(n * log(m)) | Space Complexity: O(1)
    public int maxLength(int[] ribbons, int k) {
        int left = 0;
        int right = Arrays.stream(ribbons).max().getAsInt();

        while (left < right){
            int middle = (left + right + 1) / 2;
            if (isPossible(middle, ribbons, k)){
                left = middle;
            }
            else{
                right = middle-1;
            }
        }
        return left;
    }

    public boolean isPossible(int x, int[] ribbons, int k){
        int totalRibbons = 0;
        for (int r : ribbons){
            totalRibbons += r / x;

            if (totalRibbons >= k){
                return true;
            }
        }
        return false;
    }
}
