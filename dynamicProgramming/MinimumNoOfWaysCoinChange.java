package com.practiseJava.dynamicProgramming;

public class MinimumNoOfWaysCoinChange {
  public static void main (String[] args)
  {
    int coins[] = {1,2,5};
    int m = coins.length;
    int sum = 11;
    System.out.println ( "Minimum coins required is "
        + minCoins(coins, m, sum));
  }

  static int minCoins(int coins[], int m, int sum)
  {
    // table[i] will be storing
    // the minimum number of coins
    // required for i value. So
    // table[sum] will have result
    int table[] = new int[sum + 1];

    // Base case (If given value sum is 0)
    table[0] = 0;

    // Initialize all table values as Infinite
    for (int i = 1; i <= sum; i++)
      table[i] = Integer.MAX_VALUE;

    // Compute minimum coins required for all
    // values from 1 to sum
    for (int i = 1; i <= sum; i++)
    {
      // Go through all coins smaller than i
      for (int j = 0; j < m; j++)
        if (coins[j] <= i)
        {
          int sub_res = table[i - coins[j]];
          if (sub_res != Integer.MAX_VALUE
              && sub_res + 1 < table[i])
            table[i] = sub_res + 1;


        }

    }

    if(table[sum]==Integer.MAX_VALUE)
      return -1;

    return table[sum];

  }
  // Driver program
}
