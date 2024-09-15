package com.practiseJava.slidingwindow;

/*
* You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.

After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

Example 1:

Input: s = "XYYX", k = 2

Output: 4
* */
public class LongestRepeatingSubstring {

  public static void main(String[] args) {
    System.out.println(characterReplacement("AABABBA", 1));
  }

  public static int characterReplacement(String s, int k) {
    int[] arr = new int[26];

    int ans = 0;
    int max = 0;
    int i = 0;
    for (int j = 0; j < s.length(); j++) {
      arr[s.charAt(j) - 'A']++;
      max = Math.max(max, arr[s.charAt(j) - 'A']);

      if (j - i + 1 - max > k) {
        arr[s.charAt(i) - 'A']--;
        i++;
      }
      ans = Math.max(ans, j - i + 1);
    }
    return ans;
  }
}
