package com.practiseJava.hashing;

import java.util.HashMap;

/*Given an unsorted array of integers, find the number of subarrays having a sum exactly equal to a given number k.
Input : arr[] = {10, 2, -2, -20, 10}, k = -10
Output : 3
Explanation: arr[0…3], arr[1…4], arr[3..4] have sum -10.

Input : arr[] = {9, 4, 20, 3, 10, 5}, k = 33
Output : 2
Explanation: arr[0…2], arr[2…4] have sum 33.

Input : arr[] = {1, 3, 5}, k = 2
Output : 0
* */
public class CountSubArraysHavingSum {

  public static void main(String[] args) {
    int arr[] = { 10, 2, -2, -20, 10 };
    int sum = -10;
    int n = arr.length;
    System.out.println(findSubarraySum(arr, n, sum));
  }

  private static int findSubarraySum(int[] arr, int n, int sum) {
    // Create a Hashmap (hm) to store a key-value pair, i.e, key = prefix sum and value = its index,
    // and a variable to store the current sum (curr_sum = 0).
    HashMap<Integer, Integer> prevSum = new HashMap<>();
    prevSum.put(0,1);
    int res = 0;

    // Sum of elements so far.
    int currSum = 0;

    for (int i = 0; i < n; i++) {

      // Add current element to sum so far.
      currSum += arr[i];
      //calculate the sum that have to be removed
      //so that we can get the desired sum

      int removeSum=currSum-sum;

      //get count of occurrences of that sum that
      //have to removed and add it to res value
      if (prevSum.containsKey(removeSum))
        res += prevSum.get(removeSum);

      // Add currsum value to count of
      // different values of sum.
      prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
    }

    return res;
  }
}
