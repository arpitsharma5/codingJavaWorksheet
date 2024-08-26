package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import javax.swing.tree.TreeNode;

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
    System.out.println(merge2(arr1, arr2));
  }

  private static ArrayList<Integer> merge2(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
    ArrayList<Integer> res = new ArrayList<>();
    Collections.sort(arr1);
    Collections.sort(arr2);
    int n = arr1.size();
    int m = arr2.size();
    int i= 0, j= 0;
    while (i < n & j < m) {
      if(arr1.get(i) <= arr2.get(j)) {
        res.add(arr1.get(i));
        i++;
      } else {
        res.add(arr2.get(j));
        j++;
      }
    }
    while (i < n) {
      res.add(arr1.get(i));
      i++;

    }
    while (j < m ) {
      res.add(arr2.get(j));
      j++;

    }
    return res;
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
