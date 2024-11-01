class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public String makeFancyString(String s) {
        if (s.length() < 3){
            return s;
        }

        StringBuilder newStr = new StringBuilder();
        newStr.append(s.charAt(0)).append(s.charAt(1));

        for (int i = 2; i < s.length(); i++){
            if (s.charAt(i) != newStr.charAt(newStr.length() - 1) || s.charAt(i) != newStr.charAt(newStr.length() - 2)){
                newStr.append(s.charAt(i));
            }
        }
        return newStr.toString();
    }
}
