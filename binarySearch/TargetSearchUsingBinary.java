package com.practiseJava.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
/*
* Given a sorted array arr of n integers and a target value k. Write a program to find the indices
*  of the first and the last occurrences of the target value. If the target is not found then return -1 as indices.*/
public class TargetSearchUsingBinary {

  public static void main(String[] args) {
    int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
    int len = arr.length;
    int target = 8;
    int first = firstPosition(arr, len, target);
    int last = lastPosition(arr, len, target);
    System.out.println("The first and last positions are: "
        + first + " " + last);
  }

  private static int lastPosition(int[] arr, int len, int target) {
    int low = 0, high = len - 1;
    int last = -1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
          last = mid;
          low = mid + 1;
        } else if (arr[mid] < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
    }
    return last;
  }

  private static int firstPosition(int[] arr, int len, int target) {
    int low = 0;
    int high = len - 1;
    int first = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target) {
        first = mid;
        high = mid - 1;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return first;
  }
}


