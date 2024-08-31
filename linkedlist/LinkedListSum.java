package com.practiseJava.linkedlist;

public class LinkedListSum extends PrintNode{
public static void main(String[] args) {
  ListNode l1 = new ListNode(1);
  l1.next = new ListNode(2);
  l1.next.next = new ListNode(4);
  l1.next.next.next = new ListNode(3);

  ListNode l2 = new ListNode(5);
  l2.next = new ListNode(4);
  l2.next.next = new ListNode(6);

  printList(addTwoNumbers(l1,l2));
}

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry == 1) {
      int sum = 0;
      if(l1 != null) {
        sum += l1.item;
        l1 = l1.next;
      }
      if(l2 != null) {
        sum += l2.item;
        l2 = l2.next;
      }
      sum = sum + carry;
      carry = sum /10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
    }
    return dummy.next;
  }
}
