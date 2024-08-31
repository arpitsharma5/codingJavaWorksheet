package com.practiseJava.linkedlist;

public abstract class PrintNode {
  static void printList(ListNode node) {
    if (node == null) {
      return;
    }
    while (node != null) {
      System.out.print(node.item + " ");
      node = node.next;
    }
  }
}
