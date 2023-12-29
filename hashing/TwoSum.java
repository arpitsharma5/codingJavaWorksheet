package com.practiseJava.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSum {
  public static void main(String[] args) {
    System.out.println(getCount(List.of(1, 4, 45, 6, 10, 8), 16));
  }

  private static List<Integer> getCount(List<Integer> A, int B) {
    HashMap<Integer, Integer> hs = new HashMap();
    List<Integer> res = new ArrayList<>(2);

    for (int i = 0; i < A.size(); i++) {
      if(hs.containsKey(B-A.get(i))) {
        res.add(0, hs.get(B-A.get(i)) +1);
        res.add(1, i+1);
        return res;
      } else {
        hs.put(A.get(i), i);
      }
    }
    return res;
  }
}
