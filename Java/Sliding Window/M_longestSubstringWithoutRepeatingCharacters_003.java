class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            }
            else{
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            
        }
        return maxLength;
    }
}
