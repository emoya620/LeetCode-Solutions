class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int n : arr1){
            counts[n]++;
        }

        int[] sortedArray = new int[arr1.length];
        int index = 0;
        for (int n : arr2){
            int curCount = counts[n];
            while (curCount > 0){
                sortedArray[index] = n;
                index++;
                curCount--;
            }
            counts[n] = 0;
        }

        for (int i = 0; i < counts.length; i++){
            int curCount = counts[i];
            while (curCount > 0){
                sortedArray[index] = i;
                index++;
                curCount--;
            }
        }
        return sortedArray;
    }
}
