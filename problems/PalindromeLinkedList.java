/*
Given a singly linked list, determine if it is a palindrome.
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
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        if (head.next == null)
            return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode curr = head2;
        ListNode dummy = curr.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = temp;
        }
        head2.next = null;
        
        ListNode curr1 = head;
        ListNode curr2;
        if (curr == null)
            curr2 = dummy;
        else
            curr2 = curr;
        while (curr2 != null) {
            if (curr1.val != curr2.val)
                return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
}
