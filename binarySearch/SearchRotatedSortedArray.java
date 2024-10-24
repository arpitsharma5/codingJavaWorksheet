package com.practiseJava.binarySearch;

/*
contraint solve in O(logn) time
* Input: nums = [3,4,5,6,1,2], target = 1

Output: 4*/
public class SearchRotatedSortedArray {

  public static void main(String[] args) {
    System.out.println(search(new int[]{4,5,6,7,0,1,2}, 5));
  }

  public static int search(int[] nums, int target) {
    int l=0;
    int r = nums.length -1;
    while (l <= r) {
      int mid = (l+r)/2;
      if(nums[mid] == target) {
        return mid;
      }

      if(nums[l] <= nums[mid]) { // means first half is sorted
        if(target >= nums[l] && target < nums[mid]) {
          r= mid -1;
        } else {
          l = mid +1;
        }
      } else {// means second half is sorted
        if(target > nums[mid] && target <= nums[r]) {
          l = mid +1;
        } else {
          r = mid -1;
        }
      }
    }
    return -1;
  }
}
