package com.practiseJava.hashing;

/*
*Given an array arr[] of integers and an integer sum, find a subarray that adds to a given sum.
* Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
* Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3
* */
public class SubArrayGivenSum {
  public static void main(String[] args)
  {
    SubArrayGivenSum arraysum = new SubArrayGivenSum();
    int arr[] = { 10, 2, -2, -20, 10 };
    int n = arr.length;
    int sum = -10;
    arraysum.subArraySum(arr, n, sum);
  }
  int subArraySum(int arr[], int n, int sum)
  {
    int currentSum = arr[0], start = 0, i;

    // Pick a starting point
    for (i = 1; i <= n; i++) {
      // If currentSum exceeds the sum,
      // then remove the starting elements
      while (currentSum > sum && start < i - 1) {
        currentSum = currentSum - arr[start];
        start++;
      }

      // If currentSum becomes equal to sum,
      // then return true
      if (currentSum == sum) {
        int p = i - 1;
        System.out.println(
            "Sum found between indexes " + start
                + " and " + p);
        return 1;
      }

      // Add this element to curr_sum
      if (i < n)
        currentSum = currentSum + arr[i];
    }

    System.out.println("No subarray found");
    return 0;
  }
}
