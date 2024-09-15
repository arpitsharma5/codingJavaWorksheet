package com.practiseJava.slidingwindow;

/*
* Given an array arr[] of size N and an integer K,
*  the task is to find the length of the longest subarray having the sum of its elements K, where K > 0.
* Input: arr[] = {2, 3, 5, 1, 9}, k = 10
Output: 3

* use sliding window
* */
public class LongestSubArrayHavingSumK {

  public static void main(String[] args) {
    int[] a = {2, 3, 5, 1, 9};
    long k = 10;
    System.out.println(getLongestSubarray(a, k));
  }

  private static int getLongestSubarray(int[] a, long k) {
    int n = a.length;
    int left = 0, right = 0;
    int sum = a[0];
    int maxLen = 0;
    while (right < n) {
      while(left <= right && sum > k) {
        sum -= a[left];
        left++;
      }
      if(sum == k) {
        maxLen = Math.max(maxLen, right - left + 1);
      }
      right++;
      if(right < n) {
        sum += a[right];
      }
    }
    return maxLen;
  }
}
