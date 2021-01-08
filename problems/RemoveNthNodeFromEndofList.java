/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        ListNode curr, fast; int count = 0;
        curr = fast = head;
        while (fast.next != null) {
            if (count < n) {
                count++;
                fast = fast.next;
            }
            else {
                fast = fast.next;
                curr = curr.next;
            }
        }
        if (curr == head && count < n) {
            head = head.next;
            return head;
        }
        ListNode temp = curr.next.next;
        curr.next = temp;
        return head;   
    }
}
