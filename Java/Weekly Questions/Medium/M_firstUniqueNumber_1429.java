class FirstUnique {
    private HashMap<Integer, Integer> numCounts;
    private ArrayList<Integer> uniqueNums;

    public FirstUnique(int[] nums) {
        this.numCounts = new HashMap<>();
        this.uniqueNums = new ArrayList<>();

        for (int num : nums){
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
            if (numCounts.get(num) == 1){
                uniqueNums.add(num);
            }
            else if (numCounts.get(num) == 2){
                uniqueNums.remove(Integer.valueOf(num));
            }
        }
    }
    
    public int showFirstUnique() {
        return uniqueNums.size() != 0 ? uniqueNums.get(0) : -1;
    }
    
    public void add(int value) {
        numCounts.put(value, numCounts.getOrDefault(value, 0) + 1);
        if (numCounts.get(value) == 1){
            uniqueNums.add(value);
        }
        else if (numCounts.get(value) == 2){
            uniqueNums.remove(Integer.valueOf(value));
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
