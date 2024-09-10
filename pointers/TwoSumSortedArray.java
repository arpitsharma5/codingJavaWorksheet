package com.practiseJava.pointers;

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