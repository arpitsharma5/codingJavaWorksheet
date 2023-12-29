package com.practiseJava.hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
* Given a string A, find the longest substring without repeating characters.
* */
public class LongestSubstring {
  public static void main(String[] args) {
    System.out.println(getLength("abccbad"));
//    System.out.println(getLength("GEEKSFORGEEKS"));
//    System.out.println(getLength("enjoyalgorithms"));
  }

  private static int getLength(String A) {
    int l = 0,r = 0;
    int maxLength = 0;
    int maxL = 0, maxR = 0;
    int n = A.length();
    HashSet<Character> hashSet = new HashSet<>();
    while (r < n) {
      if(!hashSet.contains(A.charAt(r))) {
        hashSet.add(A.charAt(r));
        if (r - l + 1 > maxLength) {
          maxLength = r - l + 1;
          maxL = l;
          maxR = r;
        }
        r++;
      } else {
        hashSet.remove(A.charAt(l));
        l++;
      }
    }
    System.out.println(A.substring(maxL, maxR+1));
    return maxLength;
  }

}
