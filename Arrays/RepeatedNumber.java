package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
* You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.
* */
public class RepeatedNumber {
  public static void main(String[] args) {
    System.out.println(repeatedNumber(List.of(3,1,2,5,3)));
  }
  public static ArrayList<Integer> repeatedNumber(List<Integer> A) {
    int n = A.size();
    Collections.sort(A);
    int totalSum = n * (n+1) / 2;
    int sum = A.get(0);
    int repeatedNumber = 0;
    int missingNumber = 0;
    for(int i = 1; i < n ; i++) {
      if(A.get(i) == A.get(i-1)) {
        repeatedNumber = A.get(i);

      } else {
        sum += A.get(i);
      }
    }
    missingNumber = totalSum - sum;
    ArrayList<Integer> re = new ArrayList<>(2);
    re.add(repeatedNumber);
    re.add(missingNumber);
    return re;
  }
}
