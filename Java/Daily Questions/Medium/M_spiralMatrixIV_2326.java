/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix){
            Arrays.fill(row, -1);
        }

        int r = 0, c = 0;
        while (head != null){
            while (head != null && c < n && matrix[r][c] == -1){
                matrix[r][c] = head.val;
                head = head.next;
                c++;
            }
            c--;
            r++;

            while (head != null && r < m && matrix[r][c] == -1){
                matrix[r][c] = head.val;
                head = head.next;
                r++;
            }
            r--;
            c--;

            while (head != null && c >= 0 && matrix[r][c] == -1){
                matrix[r][c] = head.val;
                head = head.next;
                c--;
            }
            c++;
            r--;

            while (head != null && r >= 0 && matrix[r][c] == -1){
                matrix[r][c] = head.val;
                head = head.next;
                r--;
            }
            r++;
            c++;
        }
        return matrix;
    }
}
