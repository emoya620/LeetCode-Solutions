// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }

        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        int unequalChars = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                unequalChars++;

                if (unequalChars > 2){
                    return false;
                }
            }
            
            chars1[s1.charAt(i) - 'a']++;
            chars2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (chars1[i] != chars2[i]){
                return false;
            }
        }
        return true;
    }
}
