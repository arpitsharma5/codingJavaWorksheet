package com.practiseJava.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Lis - Longest Increasing subsequence
* */
public class Lis {
  public int lis(final List<Integer> A) {
    int dp[];
    int n;

    if (A == null)
      return 0;

    n = A.size();

    if (n == 0)
      return 0;

    dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; i++) {

      for (int j = 0; j < i; j++) {

        if (A.get(i) > A.get(j) && dp[i] <= dp[j])
          dp[i] = dp[j] + 1;

      }

    }

    int res = 0;

    for (int i = 0; i < n; i++)
      res = Math.max(res, dp[i]);

    return res;

  }

  public static void main(String[] args) {
    Lis lis = new Lis();
    int a[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
    List<Integer> li = new ArrayList<>(List.of(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
    System.out.println(lis.lis(li));
  }
}
