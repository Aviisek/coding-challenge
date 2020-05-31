package com.challenge.linkedList;

public class ReverseLinkedList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
        public static ListNode reverseList(ListNode head) {

            if (head == null || head.next == null) return head;

            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }

    public static void main(String[] args) {

          ListNode li = new ListNode(1);
          li.next = new ListNode(2);
          li.next.next = new ListNode(3);
          li.next.next.next = new ListNode(4);
          li.next.next.next.next = new ListNode(5);

        System.out.println(reverseList(li).val);
    }
}
