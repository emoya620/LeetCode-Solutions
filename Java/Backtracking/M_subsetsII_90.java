class Solution {
    // Time Complexity: O(n * 2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, subset, subsets, nums);
        return subsets;
    }

    public void helper(int index, List<Integer> subset, List<List<Integer>> subsets, int[] nums){
        if (index >= nums.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        helper(index + 1, subset, subsets, nums);
        subset.remove(subset.size() - 1);

        while (index < nums.length - 1 && nums[index] == nums[index+1]){
            index++;
        }
        helper(index + 1, subset, subsets, nums);
    }
}
