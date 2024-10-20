class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()){
            if (c == ',' || c == '('){
                continue;
            }

            if (c == 't' || c == 'f' || c == '|' || c == '&' || c == '!'){
                stack.push(c);
            }
            else if (c == ')'){
                boolean hasTrue = false, hasFalse = false;
                while (stack.peek() != '|' && stack.peek() != '&' && stack.peek() != '!'){
                    char topValue = stack.pop();
                    if (topValue == 't'){
                        hasTrue = true;
                    }
                    if (topValue == 'f'){
                        hasFalse = true;
                    }
                }

                char operator = stack.pop();
                if (operator == '|'){
                    stack.push(hasTrue ? 't' : 'f');
                }
                else if (operator == '&'){
                    stack.push(hasFalse ? 'f' : 't');
                }
                else{
                    stack.push(hasTrue ? 'f' : 't');
                }
            }
        }
        return stack.peek() == 't';
    }
}
