package com.practiseJava.dynamicProgramming;

/*We are given an array Arr with N distinct coins and a target. We have an infinite supply of each coin denomination. We need to find the number of ways we sum up the coin values to give us the target.

Each coin can be used any number of times.
* */
public class NumberOfWaysCoinChange {

  // Driver Code
  static long countWaysToMakeChange(int[] arr, int n, int T) {
    // Create a 2D array to store results of subproblems
    long dp[][] = new long[n][T + 1];

    // Initialize base condition for the first element of the array
    for (int i = 0; i <= T; i++) {
      if (i % arr[0] == 0)
        dp[0][i] = 1;
      // Else condition is automatically fulfilled, as dp array is initialized to zero
    }

    // Fill the dp array using dynamic programming
    for (int ind = 1; ind < n; ind++) {
      for (int target = 0; target <= T; target++) {
        long notTaken = dp[ind - 1][target];

        long taken = 0;
        if (arr[ind] <= target)
          taken = dp[ind][target - arr[ind]];

        dp[ind][target] = notTaken + taken;
      }
    }

    return dp[n - 1][T];
  }

  public static void main(String args[]) {
    int arr[] = { 1, 2, 3 };
    int target = 5;
    int n = arr.length;

    // Call the countWaysToMakeChange function and print the result
    System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
  }

}
