class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1){
            return 1;
        }
        
        int flag = 0;
        int count1 = 1, count2 = 1, count1Max = 0, count2Max = 0;

        for (int i = 1; i < arr.length; i++){
            if (flag == 0){
                if (arr[i] < arr[i-1]){
                    count1++;
                    count2 = 1;
                }
                else if (arr[i] > arr[i-1]){
                    count2++;
                    count1 = 1;
                }
                else{
                    count1 = 1;
                    count2 = 1;
                }
                count1Max = Math.max(count1Max, count1);
                count2Max = Math.max(count2Max, count2);
                flag = 1;
            }
            else{
                if (arr[i] > arr[i-1]){
                    count1++;
                    count2 = 1;
                }
                else if (arr[i] < arr[i-1]){
                    count2++;
                    count1 = 1;
                }
                else{
                    count1 = 1;
                    count2 = 1;
                }
                count1Max = Math.max(count1Max, count1);
                count2Max = Math.max(count2Max, count2);
                flag = 0;
            }
        }
        return Math.max(count1Max, count2Max);
    }
}
