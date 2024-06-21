class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxCustomers = 0;
        for (int i = 0; i < customers.length; i++){
            if (grumpy[i] == 0){
                maxCustomers += customers[i];
            }
        }

        int maxConverted = 0;
        for (int i = 0; i <= customers.length - minutes; i++){
            int curConverted = 0;
            for (int j = i; j < i + minutes; j++){
                if (grumpy[j] == 1){
                    curConverted += customers[j];
                }
            }
            maxConverted = Math.max(maxConverted, curConverted);
        }
        return maxCustomers + maxConverted;
    }
}
