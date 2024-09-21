class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        String[] phoneMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper("", digits, phoneMap, result);
        return result;
    }

    public void helper(String combination, String digits, String[] phoneMap, List<String> result){
        if (digits.length() == 0){
            result.add(combination);
        }
        else{
            String phoneChars = phoneMap[digits.charAt(0) - '2'];
            for (Character c : phoneChars.toCharArray()){
                helper(combination + c, digits.substring(1), phoneMap, result);
            }
        }
    }
}
