class Solution {
    // Time Complexoty: O(n) | Space Complexity: O(1)
    public long minimumSteps(String s) {
        int left = 0;
        long totalSwaps = 0;
        for (int right = 0; right < s.length(); right++){
            if (s.charAt(right) == '0'){
                totalSwaps += right - left;
                left++;
            }
        }
        return totalSwaps;
    }
}
