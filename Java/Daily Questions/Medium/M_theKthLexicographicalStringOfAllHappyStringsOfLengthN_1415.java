// Time Complexity: O(n * 2^n) | Space Complexity: O(n)
class Solution {
    String happyString = "";
    int numStringsGenerated = 0;
    boolean stringFound = false;

    public String getHappyString(int n, int k) {
        generateStrings("a", 1, n, k);
        generateStrings("b", 1, n, k);
        generateStrings("c", 1, n, k);

        return happyString;
    }

    public void generateStrings(String curStr, int index, int n, int k){
        if (stringFound){
            return;
        }
        if (index == n){
            numStringsGenerated++;

            if (numStringsGenerated == k){
                happyString = curStr;
                stringFound = true;
            }
            
            return;
        }

        if (curStr.charAt(index-1) == 'a'){
            generateStrings(curStr + 'b', index + 1, n, k);
            generateStrings(curStr + 'c', index + 1, n, k);
        }
        else if (curStr.charAt(index-1) == 'b'){
            generateStrings(curStr + 'a', index + 1, n, k);
            generateStrings(curStr + 'c', index + 1, n, k);
        }
        else{
            generateStrings(curStr + 'a', index + 1, n, k);
            generateStrings(curStr + 'b', index + 1, n, k);
        }
    }
}
