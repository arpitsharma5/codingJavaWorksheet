package com.practiseJava.priorityHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
* ou are given an array of integers stones where stones[i] represents the weight of the ith stone.

We want to run a simulation on the stones as follows:

At each step we choose the two heaviest stones, with weight x and y and smash them togethers
If x == y, both stones are destroyed
If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
Continue the simulation until there is no more than one stone remaining.

Return the weight of the last remaining stone or return 0 if none remain.
* Input: stones = [2,3,6,2,4]

Output: 1
* */
public class LastStoneWeight {

  public static void main(String[] args) {
    System.out.println(lastStoneWeight(new int[]{2,3,6,2,4}));
  }

  private static int lastStoneWeight(int[] weights) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    for(var i : weights) {
      pq.add(i);
    }

    while(pq.size() > 1) {
      int firstWeight = pq.poll();
      int secondWeight = pq.poll();
      if(firstWeight > secondWeight) {
        pq.add(firstWeight - secondWeight);
      }
    }
  return pq.peek();
  }
}
