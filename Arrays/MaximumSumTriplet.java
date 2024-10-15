package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
/*
* You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
* */
public class MaximumSumTriplet {
  public static void main(String[] args) {
    MaximumSumTriplet largest = new MaximumSumTriplet();
    ArrayList<Integer> inp = new ArrayList<>(
        List.of(22649, 27447, 23806, 15891, 6730, 24371, 15351, 15007, 31102, 24394, 3549, 19630, 12624, 24085 ));
    System.out.println(largest.maximumSumTriplet(inp));
  }
  public int maximumSumTriplet(List<Integer> A) {
    int n = A.size();
    int[] maxRightSuffix = new int[n];
    maxRightSuffix[n-1] = A.get(n-1);
    for(int i = n-2; i >= 0; i--) {
      maxRightSuffix[i] = Math.max(maxRightSuffix[i+1], A.get(i));
    }
    TreeSet<Integer> lowValue = new TreeSet<>();
    lowValue.add(Integer.MIN_VALUE);
    int ans=0;
    for(int i = 0; i< n-1; i++) {
      if(maxRightSuffix[i] > A.get(i)) {
        ans = Math.max(ans, lowValue.lower(A.get(i)) + A.get(i) + maxRightSuffix[i]);
        lowValue.add(A.get(i));
      }
    }
    return ans;
  }

}
