// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] charMap = new int[26];
        for (char c : s.toCharArray()){
            charMap[c - 'a']++;
        }

        int numOdd = 0;
        for (int count : charMap){
            numOdd += count % 2;
        }
        return numOdd <= 1;
    }
}
