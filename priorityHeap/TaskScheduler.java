package com.practiseJava.priorityHeap;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* You are given an array of CPU tasks, where tasks[i] is an uppercase english character from A to Z. You are also given an integer n.

Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.

The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.

Return the minimum number of CPU cycles required to complete all tasks.
* Input: tasks = ["A","A","A","B","C"], n = 3

Output: 9*/
public class TaskScheduler {

  public static void main(String[] args) {
    System.out.println(leastInterval(new char[]{'A','A','A','B','B', 'C'}, 3));
  }

    public static int leastInterval(char[] tasks, int n) {
      Map<Character, Integer> counts = new HashMap<>();
      for (char task : tasks) {
        counts.put(task, counts.getOrDefault(task, 0) + 1);
      }

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      maxHeap.addAll(counts.values());

      int time = 0;
      Deque<int[]> queue = new ArrayDeque<>();  // pairs of [cnt, idleTime]
      while (!maxHeap.isEmpty() || !queue.isEmpty()) {
        if (!queue.isEmpty() && time >= queue.peek()[1]) {
          maxHeap.offer(queue.poll()[0]);
        }
        if (!maxHeap.isEmpty()) {
          int cnt = maxHeap.poll() - 1;
          if (cnt > 0) {
            queue.offer(new int[]{cnt, time + n + 1});
          }
        }
        time++;
      }
      return time;
    }
  }