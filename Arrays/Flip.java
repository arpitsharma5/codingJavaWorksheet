package com.practiseJava.Arrays;

import java.util.ArrayList;

public class Flip {
  public static void main(String[] args) {
    Flip flip = new Flip();
//    System.out.println(flip.flip("1101010001"));
    System.out.println(flip.flip("01100"));
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
