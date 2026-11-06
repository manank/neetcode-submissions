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
    public void reorderList(ListNode head) {
        
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = reverseList(slow.next);

        // end the first
        slow.next = null;
        
        ListNode pred1 = null, curr1 = head, curr2 = head2;

        while (curr2 != null) {
            ListNode succ1 = curr1.next;
            ListNode succ2 = curr2.next;

            curr1.next = curr2;
            curr2.next = succ1;

            curr1 = succ1;
            curr2 = succ2;
        }
    }

    private ListNode reverseList(ListNode head) {

        ListNode pred = null, curr = head;
        while (curr != null) {
            ListNode succ = curr.next;
            curr.next = pred;
            pred = curr;
            curr = succ;
        }

        return pred;
    }
}
