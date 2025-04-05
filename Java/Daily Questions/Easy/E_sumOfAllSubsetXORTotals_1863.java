// Brute force solution: O(2^n)
class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0,0, nums);
    }

    public int dfs(int idx, int total, int[] nums){
        if (idx == nums.length){
            return total;
        }

        return dfs(idx + 1, total ^ nums[idx], nums) + dfs(idx + 1, total, nums);
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
