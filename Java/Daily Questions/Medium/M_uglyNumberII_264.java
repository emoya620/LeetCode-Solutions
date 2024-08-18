class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int i1 = 0, i2 = 0, i3 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++){
            ugly[i] = Math.min(ugly[i1] * 2, Math.min(ugly[i2] * 3, ugly[i3] * 5));
            if (ugly[i] == ugly[i1] * 2){
                i1++;
            }
            if (ugly[i] == ugly[i2] * 3){
                i2++;
            }
            if (ugly[i] == ugly[i3] * 5){
                i3++;
            }
        }
        return ugly[n-1];
    }
}
