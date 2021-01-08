/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode c1, c2;
        c1 = c2 = head;
        int count = 0;
        
        while ((c2.next) != null) {
            c1 = c1.next;
            c2 = c2.next;
            if (c1.equals(c2) && count != 0)
                return true;
            c2 = c2.next;
            if (c2 == null)
                return false;
            if (c1.equals(c2))
                return true;
            count++;
        }
        return false;
    }
}
