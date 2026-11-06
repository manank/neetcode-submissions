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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode curr = head, pred = sentinel;

        int nodeIndex = 1;

        while (curr != null && nodeIndex != left) {
            pred = curr;
            curr = curr.next;
            nodeIndex++;
        }

        ListNode tail1 = pred;
        pred = null;

        ListNode tail2 = curr;
        if (nodeIndex == left) {

            while (curr != null && nodeIndex <= right) {
                ListNode succ = curr.next;
                curr.next = pred;
                pred = curr;
                curr = succ;
                nodeIndex++;
            }

            ListNode head2 = pred;
            ListNode head3 = curr;

            tail1.next = head2;
            tail2.next = head3;
        }

        return sentinel.next;
    }
}