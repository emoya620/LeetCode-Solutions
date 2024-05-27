class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int numClosed = 0;
        int numOpened = 0;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c != '(' && c != ')'){
                continue;
            }

            if (c == '('){
                stack.push(c);
            }
            else{
                if (stack.size() == 0){
                    continue;
                }
                else{
                    maxDepth = Math.max(maxDepth, stack.size());
                    stack.pop();
                }
            }
        }
        return maxDepth;
    }
}
