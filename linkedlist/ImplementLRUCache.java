package com.practiseJava.linkedlist;

import java.util.HashMap;

public class ImplementLRUCache {

  public static void main(String[] args)
  {
    System.out.println("Going to test the LRU "
        + " Cache Implementation");
    ImplementLRUCache cache = new ImplementLRUCache(2);

    // it will store a key (1) with value
    // 10 in the cache.
    cache.put(1, 10);

    // it will store a key (1) with value 10 in the
    // cache.
    cache.put(2, 20);
    System.out.println("Value for the key: 1 is "
        + cache.get(1)); // returns 10

    // evicts key 2 and store a key (3) with
    // value 30 in the cache.
    cache.put(3, 30);

    System.out.println(
        "Value for the key: 2 is "
            + cache.get(2)); // returns -1 (not found)

    // evicts key 1 and store a key (4) with
    // value 40 in the cache.
    cache.put(4, 40);
    System.out.println(
        "Value for the key: 1 is "
            + cache.get(1)); // returns -1 (not found)
    System.out.println("Value for the key: 3 is "
        + cache.get(3)); // returns 30
    System.out.println("Value for the key: 4 is "
        + cache.get(4)); // return 40
  }

  int capacity;
  HashMap<Integer, Node> cache = new HashMap<>();
  Node head = new Node(0,0);
  Node tail = new Node(0,0);

  public ImplementLRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      remove(node);
      insert(node);
      return node.val;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      remove(cache.get(key));
    }
    if (cache.size() == capacity) {
      remove(tail.prev);
    }
    insert(new Node(key, value));
  }

  private void remove(Node node) {
    cache.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insert(Node node) {
    cache.put(node.key, node);
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }
}

class Node {
  int key;    int val;    Node prev;    Node next;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
    this.prev = null;
    this.next = null;
  }
}

