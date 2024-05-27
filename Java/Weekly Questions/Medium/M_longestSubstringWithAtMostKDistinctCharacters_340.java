class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> counts = new HashMap<>();
        int right = 0;
        int left = 0;
        int maxLen = 0;
        int curLen = 0;
        while (right < s.length()) {
            counts.put(s.charAt(right), counts.getOrDefault(s.charAt(right), 0) + 1);
            curLen++;

            while (left <= right && counts.size() > k){
                counts.put(s.charAt(left), counts.get(s.charAt(left)) - 1);
                if (counts.get(s.charAt(left)) == 0){
                    counts.remove(s.charAt(left));
                }
                left++;
                curLen--;
            }

            maxLen = Math.max(maxLen, curLen);
            right++;
        }
        return maxLen;
    }
}
