class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int maxVal = -1;
        for (int key : map.keySet()){
            if (map.get(key) == 1){
                maxVal = Math.max(maxVal, key);
            }
        }
        return maxVal;
    }
}
