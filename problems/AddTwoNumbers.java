/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == l2 && l1 == null)
            return null;
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        int length1 = 1, length2 = 1;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1.next != null) {
            curr1 = curr1.next;
            length1++;
        }
        while (curr2.next != null) {
            curr2 = curr2.next;
            length2++;
        }
        if (length1 < length2) {
            while (length1 < length2) {
                ListNode temp = new ListNode(0);
                curr1.next = temp;
                curr1 = curr1.next;
                length1++;
            }
        }
        if (length2 < length1) {
            while (length2 < length1) {
                ListNode temp = new ListNode(0);
                curr2.next = temp;
                curr2 = curr2.next;
                length2++;
            }
        }
        curr1 = l1; curr2 = l2;
        for (int i=0; i<length1; i++) {
            curr1.val = curr1.val + curr2.val;
            if (curr1.val >= 10) {
                if (curr1.next != null) {
                    curr1.val = curr1.val - 10;
                    curr1.next.val = curr1.next.val + 1;
                }
                else {
                    ListNode temp = new ListNode(1);
                    curr1.val = curr1.val - 10;
                    curr1.next = temp;
                }
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return l1;
    }
}
