/*
Remove all elements from a linked list of integers that have value val.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(intt val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int value) {
        if (head == null)
            return null;
        if (head.next == null) {
            if (head.val == value)
                return null;
            else
                return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val == value) {
                if (curr == head) {
                    if (head.next == null)
                        return null;
                    else {
                        head = curr = curr.next;
                    }
                }
                else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
