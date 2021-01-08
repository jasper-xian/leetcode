/*
Write a program to find the node at which the intersection of two singly linked lists begins.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode c1 = headA; ListNode c2 = headB;
        int end1, end2;
        end1 = end2 = 0;
        while (c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
            if (c1 == null) {
                c1 = headB;
                end1++;
            }
            if (c2 == null) {
                c2 = headA;
                end2++;
            }
            if (end1 > 1 || end2 > 1)
                return null;
        }
        return c1;
    }
}
