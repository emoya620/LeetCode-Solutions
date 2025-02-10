// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public String clearDigits(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isDigit(c) && newStr.length() != 0){
                newStr.setLength(newStr.length() - 1);
            }
            else{
                newStr.append(c);
            }
        }
        return newStr.toString();
    }
}
