public class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for (int num : derived) {
            sum += num;
        }
        return sum % 2 == 0;
    }
}
