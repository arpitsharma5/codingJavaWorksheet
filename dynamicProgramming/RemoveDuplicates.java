package com.practiseJava.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
  public int removeDuplicates(ArrayList<Integer> A) {
    int index = 1;
    int n = A.size();

    if (A == null || A.size() == 0)
      return 0;

    for (int i = 1; i < n; i++) {

      if (A.get(i) != A.get(i - 1)) {
//        int temp = A.get(index);
        A.set(index, A.get(i));
        index++;
      }
    }
    System.out.println(A);
    return index;

  }
public static void main(String[] args) {
  RemoveDuplicates removeDuplicates = new RemoveDuplicates();
  ArrayList<Integer> li = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3));

  System.out.println(removeDuplicates.removeDuplicates(li));
}
}
