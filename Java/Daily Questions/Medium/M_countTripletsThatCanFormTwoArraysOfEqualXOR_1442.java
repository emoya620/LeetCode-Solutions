class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++){
            int curXOR = arr[i];
            for (int k = i+1; k < arr.length; k++){
                curXOR ^= arr[k];

                if (curXOR == 0){
                    ans += k-i;
                }
            }
        }
        return ans;
    }
}
