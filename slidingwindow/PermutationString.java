package com.practiseJava.slidingwindow;

import java.util.HashMap;
import java.util.Map.Entry;
/*
* permutation of s1 should be present in s2
* */
public class PermutationString {

  public static void main(String[] args) {
    System.out.println(checkInclusion("adc", "dcda"));
  }

    public static boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) {
        return false;
      }
      HashMap<Character, Integer> map1 = new HashMap<>();
      HashMap<Character, Integer> map2 = new HashMap<>();
      for(int i=0; i < s1.length(); i++) {
        map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
        map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
      }
      if(checkEqual(map1, map2)) {
        return true;
      }
      int l = s1.length();
      int removeIndex = 0;
      while (l < s2.length()) {
        map2.put(s2.charAt(l), map2.getOrDefault(s2.charAt(l), 0)+1);
        map2.put(s2.charAt(removeIndex), map2.getOrDefault(s2.charAt(removeIndex), 0) -1);
        if(checkEqual(map1, map2)) {
          return true;
        }
        l++;
        removeIndex++;
      }
      return false;
    }

  private static boolean checkEqual(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
    int matchCount = 0;
    for(Entry<Character, Integer> eachEntry : map1.entrySet()) {
      if(eachEntry.getValue().equals(map2.get(eachEntry.getKey()))) {
        matchCount++;
      }
    }
    return matchCount == map1.size();
  }


}
