package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
  int start, end;

  Interval(int start, int end)
  {
    this.start = start;
    this.end = end;
  }
}

public class MergeIntervals {
  public static void main(String []args) {
    ArrayList<Interval> intervals = new ArrayList<>();
    Interval interval1 = new Interval(6,8);
    Interval interval2 = new Interval(1, 2);
    Interval interval3 = new Interval(3, 4);
    Interval interval4 = new Interval(4, 7);
    Interval interval5 = new Interval(10, 11);
    intervals.add(interval1);
    intervals.add(interval2);
    intervals.add(interval3);
    intervals.add(interval4);
    intervals.add(interval5);
    System.out.println(mergeIntervals(intervals));
  }
  static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
    Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
    ArrayList<Interval> res = new ArrayList<>();
    int index = 0;
    /*for(int i = 1; i < intervals.size(); i++) {
      if(intervals.get(index).end >= intervals.get(i).start) {
        intervals.get(index).end = Math.max(intervals.get(index).end, intervals.get(i).end);
      } else {
        res.add(intervals.get(index));
        intervals.set(index, intervals.get(i));
      }
    }
    res.add(intervals.get(index));*/

    for(int i = 1; i < intervals.size(); i++) {
      if(intervals.get(index).end >= intervals.get(i).start) {
        intervals.get(index).end = Math.max(intervals.get(index).end, intervals.get(i).end);
      } else {
        res.add(intervals.get(index));
        index = i;
      }
    }
    res.add(intervals.get(index));
    return res;
  }
}
