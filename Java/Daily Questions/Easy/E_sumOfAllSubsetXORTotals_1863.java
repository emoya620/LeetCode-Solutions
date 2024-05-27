// Brute force solution: O(2^n)
class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0,0, nums);
    }

    public int dfs(int index, int total, int[] nums){
        if (index == nums.length){
            return total;
        }

        return dfs(index + 1, total ^ nums[index], nums) + dfs(index + 1, total, nums);
    }
}

// (Optimal) Mathematical solution: O(n)
class Solution2{
    public int subsetXORSum(int[] nums){
        int result = 0;
        for (int n : nums){
            result |= n;
        }

        return result * (int)Math.pow(2, nums.length - 1);
    }
}
