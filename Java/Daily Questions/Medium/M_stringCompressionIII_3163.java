class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int index = 0;
        while (index < word.length()){
            int count = 1;
            char curChar = word.charAt(index);
            index++;

            while (index < word.length() && count < 9 && curChar == word.charAt(index)){
                index++;
                count++;
            }
            comp.append(count).append(curChar);
        }
        return comp.toString();
    }
}
