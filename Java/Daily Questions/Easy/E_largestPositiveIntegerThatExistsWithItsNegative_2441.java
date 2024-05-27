class Solution {
    public int findMaxK(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums){
            int key = Math.abs(n);
            if (n >= 0 && count.containsKey(key) && count.get(key) == -1){
                count.put(key, 0);
            }
            else if (n >= 0 && !count.containsKey(key)){
                count.put(key, 1);
            }

            if (n < 0 && count.containsKey(key) && count.get(key) == 1){
                count.put(key, 0);
            }
            else if (n < 0 && !count.containsKey(key)){
                count.put(key, -1);
            }
            
        }

        int max = -1;
        for (int key : count.keySet()){
            if (count.get(key) == 0){
                max = Math.max(max, key);
            }
        }
        return max;
    }
}
