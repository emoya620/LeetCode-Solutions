// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26){
            return 0;
        }

        int ans = 0;
        int n = s.length();
        int left = 0, right = 0;
        int[] freq = new int[26];
        while (right < n){
            freq[s.charAt(right) - 'a']++;

            while (freq[s.charAt(right) - 'a'] > 1){
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == k){
                ans++;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
