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

// Time Complexity: O(n * log(m))
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // If linked list is empty, return null
        if (head == null){
            return null;
        }

        // Initialize our ListNodes for traversing the linked list
        ListNode first = head;
        ListNode second = first.next;

        // Loop through linked list until we reach the final node 
        while (second != null){
            int greatestCommonDivisor = Math.min(first.val, second.val);

            // Find the greatest common divisor between two nodes
            while (greatestCommonDivisor >= 1){
                if (first.val % greatestCommonDivisor == 0 && second.val % greatestCommonDivisor == 0){
                    ListNode newNode = new ListNode(greatestCommonDivisor);
                    newNode.next = second;
                    first.next = newNode;
                    break;
                }
                else if (first.val % greatestCommonDivisor != 0){
                    greatestCommonDivisor -= first.val % greatestCommonDivisor;
                }
                else{
                    greatestCommonDivisor -= second.val % greatestCommonDivisor;
                }
            }
            first = second;
            second = second.next;
        }
        return head;
    }
}
