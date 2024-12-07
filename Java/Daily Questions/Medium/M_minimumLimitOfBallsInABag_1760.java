class Solution {
    // Time Complexity: O(n * log(k)) | Space Complexity: O(1)
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int n : nums){
            right = Math.max(right, n);
        }

        while (left < right){
            int middle = (left + right) / 2;
            if (isPossible(middle, nums, maxOperations)){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations){
        int totalOperations = 0;
        for (int n : nums){
            int operations = (int) Math.ceil(n / (double) maxBallsInBag) - 1;
            totalOperations += operations;

            if (totalOperations > maxOperations){
                return false;
            }
        }
        return true;
    }
}
