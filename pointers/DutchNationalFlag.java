package com.practiseJava.pointers;

import java.util.ArrayList;
import java.util.List;

/*
*
* Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.*/
public class DutchNationalFlag {
  public static void main(String[] args) {
    DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
    ArrayList<Integer> inp = new ArrayList<>(List.of(2, 1,2,0,1,2));
    System.out.println(dutchNationalFlag.getArray(inp));
  }
  public ArrayList<Integer> getArray(ArrayList<Integer> A) {
    int len = A.size();
    int start= 0;
    int end = len - 1;
    int i = 0;
    while(i <= end) {
      if(A.get(i) == 0) {
        int temp = A.get(start);
        A.set(start, 0);
        A.set(i, temp);
        start++;
        i++;
      } else if(A.get(i) == 2) {
        int temp = A.get(end);
        A.set(end, 2);
        A.set(i, temp);
        end--;
      } else {
        i++;
      }
    }
    return A;
  }
}
