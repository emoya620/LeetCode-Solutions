class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c != ')' && c != '('){
                newStr.append(c);
            }
            else if (c == '('){
                stack.push(newStr.length());
            }
            else{
                if (!stack.isEmpty()){
                    int index = stack.pop();
                    newStr.insert(index, "(");
                    newStr.append(c);
                }
            }
        }

        return newStr.toString();
    }
}
