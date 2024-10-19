package com.practiseJava.Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {
  public static void main(String args[]) {
    int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
    System.out.println(topKFrequent(arr, 2));
  }

  private static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> countMap = new HashMap<>();
    int ans[] = new int[k];
    for(var num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(

        (o1, o2) -> o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey())
            : o2.getValue().compareTo(o1.getValue()));

    for(var entry: countMap.entrySet()) {
      priorityQueue.add(entry);
    }

    for(int i=0; i< k; i++) {
      ans[i] = priorityQueue.poll().getKey();
    }
    return ans;
  }
}
