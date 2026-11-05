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

    private ListNode headOfReversedList = null;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        helper(head);

        return headOfReversedList;    
    }

    private ListNode helper(ListNode head) {

        if (head.next == null) {
            headOfReversedList = head;
            return head;
        }

        ListNode succ = head.next;
        head.next = null;

        ListNode tail = helper(succ);
        tail.next = head;
        
        return head;
    }
}
