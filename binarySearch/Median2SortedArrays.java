package com.practiseJava.binarySearch;

public class Median2SortedArrays {

  public static void main(String[] args) {
    int[] arr1 = {1 ,2,3,4};
    int[] arr2 = {5,6,7,8,9};
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
      int midOfArray1 = (l + r) / 2;
      int jOfArray2 = half - midOfArray1;

      int Aleft = midOfArray1 > 0 ? A[midOfArray1 - 1] : Integer.MIN_VALUE;
      int Aright = midOfArray1 < A.length ? A[midOfArray1] : Integer.MAX_VALUE;
      int Bleft = jOfArray2 > 0 ? B[jOfArray2 - 1] : Integer.MIN_VALUE;
      int Bright = jOfArray2 < B.length ? B[jOfArray2] : Integer.MAX_VALUE;

      if (Aleft <= Bright && Bleft <= Aright) {
        if (total % 2 != 0) {
          return Math.max(Aleft, Bleft);
        }
        return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
      } else if (Aleft > Bright) {
        r = midOfArray1 - 1;
      } else {
        l = midOfArray1 + 1;
      }
    }
    return -1;
  }

  }
