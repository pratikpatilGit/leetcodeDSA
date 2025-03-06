/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node tail = findTail(current.child);

                if (current.next != null) {
                    current.next.prev = tail;
                }
                tail.next = current.next;

                current.child.prev = current;
                current.next = current.child;
                current.child = null;
            }
            current = current.next;
        }

        return head;
    }

    public Node findTail(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }
}