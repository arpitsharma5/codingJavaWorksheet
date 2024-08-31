package com.practiseJava.linkedlist;

import java.util.HashMap;

public class LinkedListCycle {
public static void main(String[] args) {
  ListNode l1 = new ListNode(1);
  l1.next = new ListNode(2);
  ListNode node = new ListNode(4);
  l1.next.next = node;
  l1.next.next.next = new ListNode(3);
  l1.next.next.next.next = node;

  System.out.println(cycle(l1));
}

  public static boolean cycle(ListNode l1) {
    HashMap<ListNode, Boolean> hmap = new HashMap<>();
    var curNode = l1;
    while(curNode != null) {
      if(hmap.containsKey(curNode)) {
        return true;
      } else {
        hmap.put(curNode, true);
        curNode = curNode.next;
      }
    }
    return false;
  }
}
