class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public boolean checkIfExist(int[] arr) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put((double)arr[i], i);
        }

        for (int i = 0; i < arr.length; i++){
            if (map.containsKey((double)arr[i] / 2) && map.get((double)arr[i] / 2) != i){
                return true;
            }
        }
        return false;
    }
}
