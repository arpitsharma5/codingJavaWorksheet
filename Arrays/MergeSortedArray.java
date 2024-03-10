package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

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

  private static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i=0; i < arr1.size(); i++) {
      pq.add(arr1.get(i));
    }
    for(int i=0; i < arr2.size(); i++) {
      pq.add(arr2.get(i));
    }
    for(int i = 0; i < arr1.size() + arr2.size(); i++) {
      arr.add(pq.poll());
    }
    return arr;
  }
}
