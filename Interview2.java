package com.practiseJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* The objective is to identify pairs within an array where the elements between them are smaller than the smallest element from the pair.

For example, the numbers in the sequence are 10, 4, 6, 8, and 7.
* */
public class Interview2 {
  public static void main(String[] args) {
    ArrayList<Integer> ll = new ArrayList<>(List.of(10,4,6,8,7));
    System.out.println(findPair(ll));
  }

  private static int findPair(ArrayList<Integer> l) {
    int n = l.size();
    int count = 0;
    for(int i = 0; i < n; i++) {
      int curMax = Integer.MIN_VALUE;
      int j = i + 2;
      while(j < n) {
        curMax = Math.max(curMax, l.get(j - 1));
        if(Math.min(l.get(i), l.get(j)) >= curMax) {
          count++;
        }
        j++;
      }
    }
    return count + n - 1;
  }
}
