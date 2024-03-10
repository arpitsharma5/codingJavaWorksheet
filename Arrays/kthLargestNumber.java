package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
QuickSelect: based on partition of large array by picking a random digit and placing it at its appropriate position
then partion the half which contains the number and repeat it again
 */

public class kthLargestNumber {

  public static void main(String[] args) {
    ArrayList<Integer> inp = new ArrayList<>(List.of(2,5,9,23,7,6,6,7,11, 10,12,8));
    System.out.println(kthLargest(inp, 2));
    System.out.println(findKthLargestByQuickSelect(inp, 0, inp.size() -1, 11));
    System.out.println(findKthSmallestByQuickSelect(inp, 0, inp.size() -1, 2));
  }

  private static int findKthSmallestByQuickSelect(ArrayList<Integer> inp, int lIndex, int rIndex, int kth) {
    int pivotPosition = partition(inp, lIndex, rIndex);
    if(pivotPosition - lIndex == kth - 1) {
      return inp.get(pivotPosition);
    }
    if(pivotPosition - lIndex > kth - 1) {
      return findKthSmallestByQuickSelect(inp, lIndex, pivotPosition - 1, kth);
    }
    return findKthSmallestByQuickSelect(inp, pivotPosition + 1, rIndex, kth - 1 - pivotPosition + lIndex );
  }

  static int kthLargest(ArrayList < Integer > arr, int K) {
    Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
    for (int i = 0; i < arr.size(); i++) {
      pq.add(arr.get(i));
    }
    int l = K - 1;
    while (l > 0) {
      pq.poll();
      l = l - 1;
    }

    return pq.peek();
  }

  public static int findKthLargestByQuickSelect(ArrayList<Integer> arr, int leftIndex, int rightIndex, int k) {
    if (k >= 0 && k <= rightIndex - leftIndex + 1) {
      int pivotPosition = partition(arr, leftIndex, rightIndex);
      if (pivotPosition - leftIndex == k-1) {
        return arr.get(pivotPosition);
      }
      if (pivotPosition - leftIndex > k - 1) {
        return findKthLargestByQuickSelect(arr, leftIndex, pivotPosition - 1, k);
      }
      return findKthLargestByQuickSelect(arr, pivotPosition + 1,
          rightIndex, k - pivotPosition + leftIndex - 1);
    }
    return 0;
  }

  public static int partition(ArrayList<Integer> arr, int left, int right) {
    int pivotPositionValue = arr.get(right), i = left;
    for (int j = left; j <= right - 1; j++) {
      if (arr.get(j) <= pivotPositionValue) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, right);
    return i;
  }

  public static void swap(ArrayList<Integer> arr, int n1, int n2) {
    int temp = arr.get(n2);
    arr.set(n2, arr.get(n1));
    arr.set(n1, temp);
  }

}
