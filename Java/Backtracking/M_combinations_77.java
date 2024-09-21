class Solution {
    // Time Complexity: O(k * C(n,k))
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        helper(1, combination, combinations, n, k);
        return combinations;
    }

    public void helper(int index, List<Integer> combination, List<List<Integer>> combinations, int n, int k){
        if (combination.size() == k){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (index > n){
            return;
        }

        for (int i = index; i <= n; i++){
            combination.add(i);
            helper(i + 1, combination, combinations, n, k);
            combination.remove(combination.size() - 1);
        }
    }
}
