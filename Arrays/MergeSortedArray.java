package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Arr1 = [9,5,6]
Arr2 = [16,12,23,8,10]

Output Arr3 = [5,6,8,9,10,12,16,23], merged and sorted of arr1 and arr2
* */
public class MergeSortedArray {

  public static void main(String[] args) {
    ArrayList<Integer> arr1 = new ArrayList(List.of(9, 5, 6));
    ArrayList<Integer> arr2 = new ArrayList(List.of(16, 12, 23, 8, 10));
    System.out.println(merge(arr1, arr2));
  }

  private static boolean merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
    Collections.sort(arr1);
    Collections.sort(arr2);

    return false;
  }
}
