// Optimized Iterative Approach
// Time Complexity: O(log_3(n)) | Space Complexity: O(1)
class Solution {
    public boolean checkPowersOfThree(int n) {
        int power = 0;
        while (Math.pow(3, power) <= n) {
            power++;
        }

        while (n > 0) {
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }
            if (n >= Math.pow(3, power)) {
                return false;
            }
            power--;
        }

        return true;
    }
}

// // My Initial Soltion: Brute-Force Solution - Backtracking
// // Time Complexity: O(2^(log_3(n))) or O(n) | Space Complexity: O(log_3(n))
// class Solution {
//     boolean validSolution = false;
    
//     public boolean checkPowersOfThree(int n) {
//         int x = 0;
//         while (Math.pow(3,x) <= n){
//             x++;
//         }
//         x--;

//         backtracking(0, x, n);
//         return validSolution;
//     }

//     public void backtracking(int curSum, int pow, int n){
//         if (validSolution){
//             return;
//         }
//         else if (curSum == n){
//             validSolution = true;
//             return;
//         }
//         else if (curSum > n || pow < 0){
//             return;
//         }

//         backtracking(curSum + (int) Math.pow(3, pow), pow-1, n);
//         backtracking(curSum, pow-1, n);
//     }
// }
