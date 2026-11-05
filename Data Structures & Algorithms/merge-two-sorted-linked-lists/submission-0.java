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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode sentinel = new ListNode(-1, null);
        ListNode list3 = sentinel;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                // move curr1 to list3
                list3.next = curr1;
                curr1 = curr1.next;
            } else {
                // move curr2 to list3
                list3.next = curr2;
                curr2 = curr2.next;
            }

            list3 = list3.next;
            list3.next = null;
        }

        if (curr1 != null) {
            list3.next = curr1;
        }
        
        if (curr2 != null) {
            list3.next = curr2;
        }

        return sentinel.next;
    }
}