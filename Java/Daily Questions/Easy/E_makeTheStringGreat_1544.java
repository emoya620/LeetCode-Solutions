class Solution {
    // We could also utilize a stack to help us do this in O(n) time
    public String makeGood(String s) {
        int left = 0;
        int right = 1;

        String newStr = "";
        while (right < s.length()){
            Character char1 = s.charAt(left);
            Character char2 = s.charAt(right);
            if (char1 != char2 && Character.toLowerCase(char1) == Character.toLowerCase(char2)){
                s = s.substring(0,left) + s.substring(right+1, s.length());
                newStr = "";
                right = 1;
                left = 0;
            }
            else{
                newStr += char1;
                right++;
                left++;
            }
        }

        if (left == s.length() - 1){
            newStr += s.charAt(s.length() - 1);
        }

        return newStr;
    }
}
