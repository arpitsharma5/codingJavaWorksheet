package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumberFormed {
  public static void main(String[] args) {
    LargestNumberFormed largest = new LargestNumberFormed();
    ArrayList<Integer> inp = new ArrayList<>(
        List.of(3,30,34,5,9));
    System.out.println(largest.largestNumber(inp));
  }
  public String largestNumber(List<Integer> A) {
    String[] arr = new String[A.size()];
    for (int i = 0; i < A.size(); i++) {
      arr[i] = String.valueOf(A.get(i));
    }
    Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

    StringBuilder str = new StringBuilder();
    for(String s : arr){
      str.append(s);
    }
    return str.toString();

  }

}
