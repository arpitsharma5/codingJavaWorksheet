package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArraySum {
public static void main(String[] args) {
  ArrayList<Integer> list1 = new ArrayList<>(List.of(1,5,6,8,9));
  ArrayList<Integer> list2 = new ArrayList<>(List.of(2,2,5,7,8,9));
  int size1 = list1.size();
  int size2 = list2.size();
  if(size1 > size2) {
    System.out.println(getSum(list1, list2, size1, size2));
  } else {
    System.out.println(getSum(list1, list2, size2, size1));
  }

}

  private static ArrayList<Integer> getSum(ArrayList<Integer> list1, ArrayList<Integer> list2,
      int size1, int size2) {
    int i = size1 - 1;
    int j = size2 - 1;
    int carry = 0;
    ArrayList<Integer> res = new ArrayList<>();

    while(j >= 0) {
      int sum = list1.get(j) + list2.get(i) + carry;
      res.add(sum%10);
      carry = sum / 10;
      i--;
      j--;
    }
    while(i >= 0) {
      int sum = list2.get(i) + carry;
      res.add(sum % 10);
      carry = sum / 10;
      i--;
    }
    if(carry > 0) {
      res.add(carry);
    }
    return res;
  }
}
