package com.practiseJava.binarySearch;
/*
* You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:

[3,4,5,6,1,2] if it was rotated 4 times.
[1,2,3,4,5,6] if it was rotated 6 times.
Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.

Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.

A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
* */
public class MinimumRotatedSortedArray {

  public static void main(String[] args) {
    System.out.println(findMin(new int[]{3,4,5,6,1,2}));
  }

  public static int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      if (nums[l] <= nums[r]) {
        return nums[l];
      }

      int mid = (l + r) / 2;
      if (nums[mid] > nums[r]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return 0;
  }
}
