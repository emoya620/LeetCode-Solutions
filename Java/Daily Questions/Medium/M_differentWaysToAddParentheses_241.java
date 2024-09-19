class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        // Check map to see if we've already calculated this expression
        List<Integer> result = map.get(expression);
        if (result != null){
            return result;
        }
        result = new ArrayList<>();

        // Base case
        if (isDigit(expression)){
            result.add(Integer.parseInt(expression));
            map.put(expression, result);
            return result;
        }

        // Recursion: Divide & Conquer
        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1, expression.length()));
                for (int l : left){
                    for (int r : right){
                        switch (c) {
                            case '+': result.add(l+r); break;
                            case '-': result.add(l-r); break;
                            case '*': result.add(l*r); break;
                        }
                    }
                }
            }
        }
        map.put(expression, result);
        return result;
    }

    public boolean isDigit(String s){
        for (Character c : s.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
