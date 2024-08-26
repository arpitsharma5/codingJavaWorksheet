package com.practiseJava.linkedlist;

/*
* You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
* Input: list1 = [1,2,4], list2 = [1,3,5]
Output: [1,1,2,3,4,5]
* */
public class MergeSortedLinkedList {

  public static void main(String args[]) {
    ListNode listNode = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode2.next = new ListNode(3);
    listNode.next.next = new ListNode(4);
    listNode2.next.next = new ListNode(5);
    printLinkedList(mergeList(listNode, listNode2));
  }

  private static ListNode mergeList(ListNode listNode, ListNode listNode2) {
    ListNode newList = new ListNode(-1);
    ListNode temp = newList;
    while (listNode != null && listNode2 != null) {
      if(listNode.item <= listNode2.item) {
        temp.next = listNode;
        listNode = listNode.next;
      } else {
        temp.next = listNode2;
        listNode2 = listNode2.next;
      }
      temp = temp.next;
    }
    if(listNode != null) {
      temp.next = listNode;
    }
    if(listNode2 != null) {
      temp.next = listNode2;
    }
    return newList.next;
  }

  static void printLinkedList(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      // Print the data of the current node
      System.out.print(temp.item + " ");
      // Move to the next node
      temp = temp.next;
    }
    System.out.println();
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
