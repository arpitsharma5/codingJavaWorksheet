package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FirstMissingInteger {
  public static void main(String[] args) {
    FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
    ArrayList<Integer> inp = new ArrayList<>(
        List.of(2, 3, -7, 6, 8, 1, -10, 15));
    System.out.println(firstMissingInteger.firstMissingPositive(inp));
  }
  public int firstMissingPositive(ArrayList<Integer> A) {

    int n = A.size() + 1;
    int count;
    int idx = 0;
    int size = A.size();
    count = size - 1;

    for (idx = size - 1; idx >= 0; idx--) {

      int num = A.get(idx);

      if (num < 0) {
        int val = A.get(count);
        A.set(idx, val);
        A.set(count, num);
        count--;
      }

    }

    for (idx = 0; idx <= count; idx++) {

      int num = A.get(idx);

      num = Math.abs(num);

      if (num > 0 && num < n) {

        int index = num - 1;
        int val = A.get(index);
        A.set(index, -val);

      }

    }

    for (idx = 0; idx <= count; idx++) {

      int num = A.get(idx);

      if (num > 0) {
        return idx + 1;
      }

    }

    return idx + 1;

  }

}
