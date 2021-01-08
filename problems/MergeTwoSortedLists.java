/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == l2 && l1 == null)
            return null;
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        ListNode curr1 = (l1.val <= l2.val ? l1:l2);
        ListNode curr2 = (curr1 == l1 ? l2: l1);
        while (curr1.next != null && curr2 != null) {
            if (curr1.val <= curr2.val && curr2.val < curr1.next.val) {
                ListNode temp = curr2.next;
                curr2.next = curr1.next;
                curr1.next = curr2;
                curr1 = curr1.next;
                curr2 = temp;
            }
            else {
                curr1 = curr1.next;
            }
        }
        if (curr1.next == null) {
            while (curr2 != null) {
                ListNode temp = curr2.next;
                curr1.next = curr2;
                curr1 = curr1.next;
                curr2 = temp;
            }
        }
        return (l1.val <= l2.val ? l1:l2);
    }
}
