class Solution {
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c : s.toCharArray()){
            count[c - 'a']++;
        }

        if (count[0] < k || count[1] < k || count[2] < k){
            return -1;
        }

        int[] window = new int[3];
        int left = 0;
        int maxWindow = 0;
        for (int right = 0; right < s.length(); right++){
            window[s.charAt(right) - 'a']++;

            while (left <= right && (count[0] - window[0] < k || count[1] - window[1] < k || count[2] - window[2] < k)){
                window[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return s.length() - maxWindow;
    }
}
