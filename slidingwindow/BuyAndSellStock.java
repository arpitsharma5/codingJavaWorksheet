package com.practiseJava.slidingwindow;

public class BuyAndSellStock {

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{10,1,5,6,7,1}));
  }

  private static int maxProfit(int[] prices) {
    int minSoFar = prices[0];
    int res = 0;

    // Update the minimum value seen so far
    // if we see smaller
    for (int i = 1; i < prices.length; i++) {
      minSoFar = Math.min(minSoFar, prices[i]);

      // Update result if we get more profit
      res = Math.max(res, prices[i] - minSoFar);
    }
    return res;
  }
}
