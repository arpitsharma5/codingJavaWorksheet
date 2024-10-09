package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;


/* Find the first missing positive integer
inp: 2, 3, -7, 6, 8, 1, -10, 15
output 4
* Follow the steps below to solve the problem:

Traverse the array, Ignore the elements which are greater than N and less than 1.
While traversing, check if a[i] ? a[a[i]-1] holds true or not .
If the above condition is true then swap a[i] and a[a[i] – 1]  and swap until (a[i] ? a[a[i] – 1]) condition fails.
Traverse the array and check whether a[i] ? i + 1 then return i + 1.
If all are equal to its index then return N+1.
* */

public class FirstMissingInteger {
  public static void main(String[] args) {
    FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
    ArrayList<Integer> inp = new ArrayList<>(
        List.of(2, 3, -7, 6, 8, 1, -10, 15));
    System.out.println(firstMissingInteger.firstMissingPositive(inp, inp.size()));
  }
  public int firstMissingPositive(ArrayList<Integer> arr, int n) {
    boolean[] bool = new boolean[n];
    for(int i = 0; i < n; i++) {
      if(arr.get(i) > 0 && arr.get(i) <= n) {
        bool[arr.get(i)-1] = true;
      }
    }
    for(int j=0; j < n; j++) {
      if(!bool[j]) {
        return j+1;
      }
    }
    return n+1;
  }

}
