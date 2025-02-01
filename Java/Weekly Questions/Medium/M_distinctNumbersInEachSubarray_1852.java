// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int ansIndex = 0;
        for (int i = 0; i < n; i++){
            int curNum = nums[i];
            countMap.put(curNum, countMap.getOrDefault(curNum, 0) + 1);

            if (i - ansIndex + 1 == k){
                ans[ansIndex] = countMap.size();

                int removeNum = nums[ansIndex];
                if (countMap.get(removeNum) == 1){
                    countMap.remove(removeNum);
                }
                else{
                    countMap.put(removeNum, countMap.get(removeNum) - 1);
                }

                ansIndex++;
            }
        }
        return ans;
    }
}
