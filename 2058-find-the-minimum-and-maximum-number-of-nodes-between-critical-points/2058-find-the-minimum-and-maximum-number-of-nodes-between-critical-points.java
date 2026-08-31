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
    public int[] criticalPoints(ListNode head) {
           int first = -1;
        int prevCP = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int pos = 1;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (first == -1) {
                    first = pos;
                } else {
                    minDist = Math.min(minDist, pos - prevCP);
                }

                prevCP = pos;
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (first == prevCP)
            return new int[]{-1, -1};

        return new int[]{minDist, prevCP - first};
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        return criticalPoints(head);
    }
}