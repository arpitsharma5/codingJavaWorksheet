package com.practiseJava.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
*
* Input: nums = [1,2,1,0,4,2,6], k = 3

Output: [2,2,4,4,6]*/
public class SlidingWindowMaximum {

  public static void main(String[] args) {
    System.out.println(maxSlidingWindow(new int[]{1,2,1,0,4,2,6}, 3));

  }

  private static int[] maxSlidingWindow(int[] a, int k) {
    int n = a.length;
    int[] res = new int[n-k+1];
    Deque<Integer> dq = new ArrayDeque<>();
    int l=0;
    int r = 0;
    while (r < n) {
      while (!dq.isEmpty() && a[r] > dq.peekLast()) {
        dq.pollLast();
      }
      dq.offer(a[r]);
      if(dq.size() > k) {
        dq.pollFirst();
      }
      if(r + 1 >= k) {
        res[l] = dq.peekFirst();
        l++;
      }
      r++;
    }
    return  res;
  }
}
