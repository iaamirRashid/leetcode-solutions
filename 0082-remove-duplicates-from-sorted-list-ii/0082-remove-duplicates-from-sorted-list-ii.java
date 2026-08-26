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
    public ListNode removeDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Duplicate found
            if (current.next != null &&
                current.val == current.next.val) {

                // Move current to the last duplicate
                while (current.next != null &&
                       current.val == current.next.val) {
                    current = current.next;
                }

                // Skip the entire duplicate group
                prev.next = current.next;

            } else {
                // Current node is unique
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        return removeDuplicates(head);
    }
}