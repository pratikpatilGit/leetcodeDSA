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
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }   

        head = reverseList(head);

        ListNode current = head;
        ListNode maxNode = head;
        ListNode prev = null;

        while (current != null) {
            if (current.val >= maxNode.val) {
                maxNode = current;
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current = current.next;
            }
        }

        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}