package com.practiseJava.linkedlist;

public class LinkedListCycle {
public static void main(String[] args) {
  ListNode l1 = new ListNode(1);
  l1.next = new ListNode(2);
  l1.next.next = new ListNode(4);
  l1.next.next.next = new ListNode(3);

  System.out.println(cycle(l1));
}

  public static boolean cycle(ListNode l1) {

    return false;
  }
  static class ListNode {
    int item;
    ListNode next;

    public ListNode(int item) {
      this.item = item;
      this.next = null;
    }
  }
}
