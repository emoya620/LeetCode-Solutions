class Solution {
    public int longestPalindrome(String s) {
        int[] charMap = new int[58];
        for (char c : s.toCharArray()){
            charMap[c - 'A']++;
        }

        int length = 0;
        boolean addedOdd = false;
        for (int n : charMap){
            if (n % 2 == 0 && n != 0){
                length += n;
            }
            else if (n % 2 == 1){
                if (n == 1 && addedOdd == false){
                    length++;
                    addedOdd = true;
                }
                else {
                    if (addedOdd == false){
                        length += n;
                        addedOdd = true;
                    }
                    else{
                        length += n - 1;
                    }
                }
            }
        }
        return length;
    }
}
