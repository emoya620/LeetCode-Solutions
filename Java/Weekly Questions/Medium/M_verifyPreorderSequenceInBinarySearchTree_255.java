class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int minVal = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int val : preorder){
            if (val < minVal){
                return false;
            }

            while (!stack.isEmpty() && val > stack.peek()){
                minVal = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
