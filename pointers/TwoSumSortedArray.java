package com.practiseJava.pointers;
/*
* Given an array of integers numbers that is sorted in non-decreasing order.

Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

There will always be exactly one valid solution.*/
public class TwoSumSortedArray {

  public static void main(String[] args) {
    int inp[] ={1,2,3,4};
    System.out.println(twoSum(inp, 3));
  }
    public static int[] twoSum(int[] numbers, int target) {
      int l = 0, r = numbers.length - 1;

      while (l < r) {
        int curSum = numbers[l] + numbers[r];

        if (curSum > target) {
          r--;
        } else if (curSum < target) {
          l++;
        } else {
          return new int[]{l + 1, r + 1};
        }
      }

      return new int[0];
    }
  }