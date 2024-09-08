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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Calculate the  length of input linked list
        ListNode temp = head;
        int length = 0;
        while (temp != null){
            temp = temp.next;
            length++;
        }

        int base = length / k;
        int remainder = length % k;

        ListNode[] arr = new ListNode[k];
        int index = 0;
        while (head != null && index < k){
            ListNode part = new ListNode(0);
            ListNode cur = part;
            cur.next = head;
            for (int i = 0; i < base; i++){
                cur = cur.next;
                head = head.next;
            }

            if (remainder > 0){
                cur = cur.next;
                head = head.next;
                remainder--;
            }

            if (cur != null){
                cur.next = null;
            }

            arr[index] = part.next;
            index++;
        }
        return arr;
    }
}
