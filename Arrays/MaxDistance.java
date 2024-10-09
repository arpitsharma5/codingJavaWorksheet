package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
* */
public class MaxDistance {
  public static void main(String[] args) {

    int[] inp = new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
    System.out.println(maxDistance(inp));
  }
  public static int maxDistance(int[] list) {
    int n = list.length;
    int maxDiff;
    int rmax[] = new int[n];
    int lmin[] = new int[n];
    lmin[0] = list[0];
    for(int i = 1; i < n ; i++) {
      lmin[i] = Math.min(list[i], lmin[i-1]);
    }

    rmax[n-1] = list[n-1];
    for(int j = n-2; j >= 0 ; j--) {
      rmax[j] = Math.max(list[j], rmax[j+1]);
    }

    int i=0;
    int j=0;
    maxDiff = Integer.MIN_VALUE;
    while (i< n && j < n) {
      if(lmin[i] <= rmax[j]) {
        maxDiff = Math.max(maxDiff, j-i);
        j++;
      } else {
        i++;
      }
    }
    return maxDiff;
  }

}
