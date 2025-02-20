// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            char c = nums[i].charAt(i);
            ans.append(c == '0' ? '1' : '0');
        }
        return ans.toString();
    }
}
