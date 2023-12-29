package com.practiseJava.dynamicProgramming;
/*
Longest Common Subsequence
* Given two strings A and B. Find the longest common sequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.
*
* */
public class LongestCommonSubsequence {
  int lcs(String str1, String str2, int length1, int length2)
  {
    int dp[][] = new int[length1 + 1][length2 + 1];

    // Following steps build dp[length1+1][length2+1] in bottom up
    // fashion. Note that dp[i][j] contains length of LCS
    // of str1[0..i-1] and str2[0..j-1]
    for (int i = 0; i <= length1; i++) {
      for (int j = 0; j <= length2; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[length1][length2];
  }

  public static void main(String[] args)
  {
    LongestCommonSubsequence lcs
        = new LongestCommonSubsequence();
    String S1 = "AGGTAB";
    String S2 = "GXTXAYB";
    int m = S1.length();
    int n = S2.length();

    System.out.println("Length of LongestCommonSubsequence is"
        + " " + lcs.lcs(S1, S2, m, n));
  }
}
