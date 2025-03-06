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
        if (head == null || left == right) {
            return head;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        ListNode next = null;
        ListNode reversedTail = current;

        for (int i = 0; i < right - left + 1; i++) {
            next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }

        reversedTail.next = current;

        return temp.next;
    }
}