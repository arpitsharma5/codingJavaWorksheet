package com.practiseJava.binarySearch;

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
