class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        StringBuilder curStr = new StringBuilder();
        char[] wordArr = word.toCharArray();
        helper(result, curStr, wordArr, 0, 0);
        return result;        
    }

    public void helper(List<String> result, StringBuilder curStr, char[] wordArr, int index, int count){
        if (index == wordArr.length){
            if (count > 0){
                curStr.append(count);
            }
            result.add(curStr.toString());
            return;
        }

        // Use a number
        int curLen = curStr.length();
        helper(result, curStr, wordArr, index + 1, count + 1);
        curStr.setLength(curLen);   // Bactracking

        // Use a character
        curLen = curStr.length();
        if (count > 0){
            curStr.append(count).append(wordArr[index]);
            helper(result, curStr, wordArr, index + 1, 0);
        }
        else{
            curStr.append(wordArr[index]);
            helper(result, curStr, wordArr, index + 1, 0);
        }
        curStr.setLength(curLen);   // Backtracking
    }
}
