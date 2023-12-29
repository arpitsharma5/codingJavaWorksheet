package com.practiseJava.Arrays;

public class LinkedListImpl<T> {

  public static void main(String args[]) {
    LinkedListImpl<Integer> list = new LinkedListImpl<>();
    list.addItem(2);
    list.addItem(5);
    list.addItem(6);
    list.addItem(1, 9);
    list.getItem(1);
    list.remove(5);
    System.out.println(list);
  }
  Node<T> head;

  private int length = 0;

  public void addItem(T data) {
    addLast(data);
  }

  void remove(T data) {
    Node prev = new Node(null);

    Node currNode = head;

    boolean exists = false;

    if(currNode != null && currNode.item == data) {
      head = currNode.next;
      exists = true;
      return;
    }

    while(currNode != null && currNode.item != data) {
      prev = currNode;
      currNode = currNode.next;
    }
    if(currNode != null) {
      prev.next = currNode.next;
      length--;
    }
    if(currNode == null) {
      throw new IndexOutOfBoundsException("key not found");
    }
  }

  // Method
  // To add new node at any given position
  public void addItem(int position, T data) {
    if(position > length) {
      throw new IndexOutOfBoundsException("index out of bound" + position);
    }
    if(position == 0) {
      Node temp = head;
      head = new Node<>(data);
      head.next = temp;
    } else if(position == length) {
      addLast(data);
    } else {
      addBefore(position, data);
    }
    length++;
  }

  private void addBefore(int position, T data) {
    Node prev = head;
    Node temp = head.next;
    for(int i = 1; i < position; i++) {
      prev = temp;
      temp = prev.next;
    }
    Node x = new Node(data);
    prev.next = x;
    x.next = temp;
  }

  private Node<T> getItem(int index) {
    if (index < 0 && index >= length) {
      throw new IndexOutOfBoundsException("index not present");
    }
    Node x = head;
    for (int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  private void addLast(T data) {
    Node<T> temp = new Node<>(data);

    if(head == null) {
      head = temp;
    } else {
      Node last = head;
      while (last.next != null) {
        last = last.next;
      }
      last.next = temp;
    }
    length++;

  }

  static class Node<T> {
    T item;
    Node next;

    public Node(T item) {
      this.item = item;
      this.next = null;
    }
  }
}
