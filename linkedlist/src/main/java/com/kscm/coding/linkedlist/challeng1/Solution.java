package com.kscm.coding.linkedlist.challeng1;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode curr1 = head1;
        while(curr1 != null) {
            System.out.println(curr1.val);
            curr1 = curr1.next;
        }
        System.out.println("------");

        ListNode head2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode curr2 = head1;
        while(curr2 != null) {
            System.out.println(curr2.val);
            curr2 = curr2.next;
        }
        System.out.println("------");

        Solution solution = new Solution();
        ListNode head3 = solution.addTwoNumbers(head1, head2);
        ListNode curr3 = head3;
        while(curr3 != null) {
            System.out.println(curr3.val);
            curr3 = curr3.next;
        }
    }
}
