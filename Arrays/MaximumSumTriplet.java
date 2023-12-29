package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MaximumSumTriplet {
  public static void main(String[] args) {
    MaximumSumTriplet largest = new MaximumSumTriplet();
    ArrayList<Integer> inp = new ArrayList<>(
        List.of(2, 5, 3, 1, 4,2 ));
    System.out.println(largest.maximumSumTriplet(inp));
  }
  public int maximumSumTriplet(List<Integer> A) {
    int n = A.size();
    int[] maxSumSuffix = new int[n+1];
    maxSumSuffix[n] = 0;
    for(int i = n -1; i>=0;i-- ) {
      maxSumSuffix[i] = Math.max(maxSumSuffix[i+1], A.get(i));
    }
    int ans = 0;
    TreeSet<Integer> lowValue = new TreeSet<>();
    lowValue.add(Integer.MIN_VALUE);

    for(int i = 0; i< n-1; i++) {
      if(maxSumSuffix[i+1] > A.get(i)) {
        ans = Math.max(ans, lowValue.lower(A.get(i)) + A.get(i) + maxSumSuffix[i+1]);
        lowValue.add(A.get(i));
      }
    }
    return ans;
  }

}
