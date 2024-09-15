package com.practiseJava.slidingwindow;

import java.util.HashMap;

/*
* Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".

You may assume that the correct output is always unique.

Example 1:

Input: s = "OUZODYXAZV", t = "XYZ"

Output: "YXAZ"
* */
public class ShortestSubstringWithCharacters {

  public static void main(String[] args) {
    System.out.println(shortestWindow("OUZODYXAZV", "XYZ"));
  }

  private static String shortestWindow(String s, String p) {
    if(s.length() < p.length())
      return "-1";
    int len1 = s.length();
    int len2 = p.length();
    HashMap<Character, Integer> hashP = new HashMap<>();
    HashMap<Character, Integer> hashS = new HashMap<>();

    for(int i=0; i <len2; i++) {
      hashP.put(p.charAt(i), hashP.getOrDefault(p.charAt(i),0) +1);
    }
    int start = 0;
    int start_index = -1;
    int minLen = Integer.MAX_VALUE;
    int matchCount = 0;
    for(int j=0; j < len1; j++) {
      char currentChar = s.charAt(j);
      hashS.put(currentChar, hashS.getOrDefault(currentChar, 0) +1);

      if(hashP.containsKey(currentChar) && hashP.get(currentChar) >= hashS.get(currentChar)) {
        matchCount++;
      }

      if(matchCount == len2) {
        while (hashS.getOrDefault(s.charAt(start),0) > hashP.getOrDefault(
            s.charAt(start), 0) || !hashP.containsKey(
            s.charAt(start))) {
          if (hashS.get(s.charAt(start)) > hashP.getOrDefault(s.charAt(start), 0)) {
            hashS.put(s.charAt(start), hashS.get(s.charAt(start)) - 1);
          }
          start++;
        }
        int len = j -start +1;
        if(minLen > len) {
          minLen = len;
          start_index = start;
        }
      }
    }
    if(start_index == -1) {
      return "-1";
    }
    return s.substring(start_index, start_index+minLen);
  }
}
