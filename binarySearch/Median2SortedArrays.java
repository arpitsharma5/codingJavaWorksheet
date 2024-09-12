package com.practiseJava.binarySearch;

public class Median2SortedArrays {

  public static void main(String[] args) {
    int[] arr1 = {-5, 3, 6, 12, 15};
    int[] arr2 = {-12, -10, -6, -3, 4, 10};
    if(arr1.length < arr2.length) {
      System.out.println(findMedianSortedArrays(arr1, arr2));
    } else {
      System.out.println(findMedianSortedArrays(arr2, arr1));
    }

  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] A = nums1;
    int[] B = nums2;
    int total = A.length + B.length;
    int half = (total + 1) / 2;


    int l = 0;
    int r = A.length;
    while (l <= r) {
      int mid = (l + r) / 2;
      int j = half - mid;

      int Aleft = mid > 0 ? A[mid - 1] : Integer.MIN_VALUE;
      int Aright = mid < A.length ? A[mid] : Integer.MAX_VALUE;
      int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
      int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

      if (Aleft <= Bright && Bleft <= Aright) {
        if (total % 2 != 0) {
          return Math.max(Aleft, Bleft);
        }
        return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
      } else if (Aleft > Bright) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

  }
