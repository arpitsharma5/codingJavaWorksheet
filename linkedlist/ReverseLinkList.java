package com.practiseJava.linkedlist;


/*Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

Example 1:

Input: head = [0,1,2,3]

Output: [3,2,1,0]
* */
public class ReverseLinkList extends PrintNode{
  public static void main(String [] args) {
    ListNode listNode = new ListNode(0);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(3);
    printList(reverseList(listNode));
  }

  public static ListNode reverseList(ListNode head) {
    var curr = head;
    ListNode next;
    ListNode prev = null;
    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
