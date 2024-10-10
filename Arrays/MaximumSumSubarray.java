package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array X[] of n integers, write a program to find the maximum sum of a subarray among all subarrays.
*  A subarray of array X[] is a contiguous segment of elements from X[i] to X[j], where 0 <= i <= j <= n - 1.
* kadane algo
* */
public class MaximumSumSubarray {

  public static void main(String []args) {
    int[] arr = {-4, 5,7,-6,10,-15,3};
    System.out.println(findMaximumSumSubarray(arr));
  }

  private static int findMaximumSumSubarray(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE, sum = 0;
    int start=0;
    int end = 0;
    int tempStart = 0;
    for(int i=0;i<n;i++){
      sum += nums[i];
      if(sum > max) {
        max = sum;
        start = tempStart;
        end = i;
      }

      if(sum<0) {
        sum = 0;
        tempStart = i + 1;
      }

    }
    System.out.println(start + "    " + end);

    return max;
  }

}
