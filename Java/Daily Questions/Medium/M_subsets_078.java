class Solution {
    List<List<Integer>> allSubsets = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return allSubsets;
    }

    public void helper(int[] nums, int start, List<Integer> set){
        if (start >= nums.length){
            allSubsets.add(new ArrayList<>(set));
        }
        else {
            set.add(nums[start]);
            helper(nums, start + 1, set);
            set.remove(set.size() - 1);
            helper(nums, start + 1, set);
        }
    }
}
