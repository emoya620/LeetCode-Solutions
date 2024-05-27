class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                mainStack.push(i);
            }
            else if (c == '*'){
                asteriskStack.push(i);
            }
            else{
                if (!mainStack.isEmpty()){
                    mainStack.pop();
                }
                else if (!asteriskStack.isEmpty()){
                    asteriskStack.pop();
                }
                else{
                    return false;
                }
            }
        }

        while (!mainStack.isEmpty()){
            if (asteriskStack.isEmpty()){
                return false;
            }

            int asteriskIndex = asteriskStack.pop();
            int parenthesesIndex = mainStack.pop();
            if (parenthesesIndex > asteriskIndex){
                return false;
            }
        }
        return true;
    }
}
