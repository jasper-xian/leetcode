/*
Given the head of a linked list, rotate the list to the right by k places.
*/

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        if (k == 0)
            return head;
        int length = 1; ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        k = k % length;
        if (k==0)
            return head;
        int n = length - k - 1;
        curr = head;
        for (int i=0; i<n; i++) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        ListNode newCurr = newHead;
        while (newCurr.next != null) {
            newCurr = newCurr.next;
        }
        newCurr.next = head;
        return newHead;
    }
}
