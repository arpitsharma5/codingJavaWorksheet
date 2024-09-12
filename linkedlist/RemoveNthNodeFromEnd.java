package com.practiseJava.linkedlist;

/*
* Input: head = [1,2,3,4], n = 2

Output: [1,2,4]*/
public class RemoveNthNodeFromEnd extends PrintNode{
  public static void main(String args[]) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    printList(removeNthNode(head, 5));
  }

  private static ListNode removeNthNode(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;

    for(int i=0; i < n ; i++) {
      fast= fast.next;
    }

    if(fast == null){
      head = head.next;
      return head;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return head;
  }

}
