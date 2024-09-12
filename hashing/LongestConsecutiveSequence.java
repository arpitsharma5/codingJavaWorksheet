package com.practiseJava.hashing;

import java.util.HashSet;
import java.util.List;

/*
* Given [100, 4, 200, 1, 3, 2],

The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
* */
public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    System.out.println(getCount(List.of(100, 4, 200, 1, 3, 2)));
  }

  static int getCount(List<Integer> A){
    HashSet<Integer> hs = new HashSet<>();
    hs.addAll(A);
    int longestLength= 0;
    for(int i=0; i < A.size(); i++) {
      if(!hs.contains(A.get(i) - 1)) {
        int curLen = 1;
        int curElement = A.get(i);
        while(hs.contains(curElement + 1)) {
          curLen++;
          curElement++;
        }
        longestLength = Math.max(longestLength, curLen);
      }
    }
    return longestLength;
  }
}
