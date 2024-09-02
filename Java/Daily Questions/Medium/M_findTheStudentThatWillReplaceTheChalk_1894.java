class Solution {
   public int chalkReplacer(int[] chalk, int k) {
        long chalkSum = 0;
        for (int n : chalk) {
            chalkSum += n;
        }
        
        int remainingChalk = (int)(k % chalkSum);
        for (int i = 0; i < chalk.length; i++) {
            if (remainingChalk < chalk[i]) {
                return i;
            }
            remainingChalk -= chalk[i];
        }
        return 0;  
    }
    
    // My Initial Solution:
    // public int chalkReplacer(int[] chalk, int k) {
    //     while (true){
    //         for (int i = 0; i < chalk.length; i++){
    //             if (chalk[i] > k){
    //                 return i;
    //             }
    //             k -= chalk[i];
    //         }
    //     }
    // }
}
