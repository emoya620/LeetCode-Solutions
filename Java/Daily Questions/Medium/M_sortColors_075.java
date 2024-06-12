class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int n : nums){
            counts[n]++;
        }

        int index = 0;
        for (int i = 0; i < counts.length; i++){
            while (counts[i] > 0){
                nums[index] = i;
                index++;
                counts[i]--;
            }
        }
    }
}
