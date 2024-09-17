package com.practiseJava.Arrays;

import java.util.ArrayList;
/*
* You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.*/
public class Flip {
  public static void main(String[] args) {
    Flip flip = new Flip();
    System.out.println(flip.flip("1101010001")); // 3,9
//    System.out.println(flip.flip("01100"));
  }

  public ArrayList<Integer> flip(String A) {
    int maxSum = Integer.MIN_VALUE;
    int curSum = 0;
    int startIndex = 0;
    int endIndex = 0;
    boolean flag = false;
    int start = 0;
    ArrayList<Integer> res = new ArrayList<>(2);
    for(int i = 0; i < A.length(); i++) {
      if(A.charAt(i) == '0') {
        flag = true;
      }
      curSum += A.charAt(i) == '0' ? 1 : -1;
      if(curSum > maxSum) {
        maxSum = curSum;
        startIndex = start;
        endIndex = i;
      }
      if(curSum < 0) {
        curSum = 0;
        start = i+1;
      }
    }
    if(!flag)
      return res;
    res.add(startIndex+1);
    res.add(endIndex+1);
    return res;
  }
}
