package com.practiseJava.dynamicProgramming;
/*
Longest Common Subsequence
* Given two strings A and B. Find the longest common sequence
 ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.
*
* */
public class LongestCommonSubsequence {
  public static int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    for (int i = text1.length() - 1; i >= 0; i--) {
      for (int j = text2.length() - 1; j >= 0; j--) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = 1 + dp[i + 1][j + 1];
        } else {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }
    return dp[0][0];
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
        + " " + longestCommonSubsequence(S1, S2));
  }
}
