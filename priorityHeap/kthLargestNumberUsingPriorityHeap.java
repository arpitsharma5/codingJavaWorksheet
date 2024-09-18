package com.practiseJava.priorityHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
QuickSelect: based on partition of large array by picking a random digit and placing it at its appropriate position
then partion the half which contains the number and repeat it again
 */

public class kthLargestNumberUsingPriorityHeap {

  public static void main(String[] args) {
    ArrayList<Integer> inp = new ArrayList<>(List.of(2,5,9,23,7,6,6,7,11, 10,12,8));
    System.out.println(kthLargest(inp, 2));
  }

  static int kthLargest(ArrayList < Integer > arr, int K) {
    Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
    for (int i = 0; i < arr.size(); i++) {
      pq.add(arr.get(i));
    }
    int popIndex = K - 1 ;
    while(popIndex > 0) {
      pq.poll();
      popIndex--;
    }
    return pq.peek();
  }

}
