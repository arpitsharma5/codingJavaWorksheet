package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
* */
public class MaxDistance {
  public static void main(String[] args) {
    ArrayList<Integer> inp = new ArrayList<>(
        List.of(3, 5, 4, 2));
    System.out.println(maxDistance(inp));
  }
  public static int maxDistance(List<Integer> list) {
    int size = list.size();

    List<Helper> helpers = new ArrayList<>(size);
    Map<Integer, Integer> mp = new HashMap<>(size);
    // Add each element into an helper array
    for (int i = 0; i < size; i++) {
      helpers.add(new Helper(list.get(i), i));
    }
    // Sort the helper array
    Collections.sort(helpers);

    int[] rightMax = new int[size];
    int maxValue = Integer.MIN_VALUE;

    // Store the max value from the right to the left
    for (int i = size - 1; i >= 0; i--) {
      maxValue = Math.max(maxValue, helpers.get(i).index);
      rightMax[i] = maxValue;
    }

    int maxDiff = Integer.MIN_VALUE;

    // Iterate over helper and check the diff value
    for (int i = 0; i < size; i++) {
      maxDiff = Math.max(maxDiff, rightMax[i] - helpers.get(i).index);
    }

    return maxDiff;

  }
  }


class Helper implements Comparable<Helper> {
  public int value;
  public int index;

  public Helper(int value, int index) {
    this.value = value;
    this.index = index;
  }

  @Override
  public int compareTo(Helper helper) {
    // Comparison on the value

    if (value < helper.value) {
      return -1;
    } else if (value == helper.value) {
      return 0;
    } else {
      return 1;
    }
  }
}
