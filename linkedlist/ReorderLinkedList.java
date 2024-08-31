package com.practiseJava.linkedlist;

import static com.practiseJava.linkedlist.ReverseLinkList.reverseList;

/*Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:

[0, n-1, 1, n-2, 2, n-3, ...]
* Input: head = [2,4,6,8,10]

Output: [2,10,4,8,6]*/
public class ReorderLinkedList extends PrintNode{

  public static void main(String args[]) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    printList(reorderList(head));
  }

  public static ListNode reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while(fast !=null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode firstHalf = head;
    ListNode secondHalf = slow.next;
    slow.next = null;

    // reverse the linked list
    secondHalf = reverseList(secondHalf);

    // merge alternate nodes from 2 halves
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (firstHalf != null || secondHalf != null) {
      if(firstHalf != null) {
        curr.next = firstHalf;
        curr = firstHalf;
        firstHalf = firstHalf.next;
      }
      if(secondHalf != null) {
        curr.next = secondHalf;
        curr = secondHalf;
        secondHalf = secondHalf.next;
      }
    }
    return dummy.next;
  }
}
