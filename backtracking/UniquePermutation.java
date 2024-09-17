package com.practiseJava.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniquePermutation {

  public static void main(String args[]) {
    ArrayList<Integer> A = new ArrayList<>(List.of(1,1,2));
    System.out.println(permute(A));
  }

  public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    ArrayList<Integer> curr=new ArrayList<>();
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    Collections.sort(A);
    boolean[] visited=new boolean[A.size()];
    recur(res,curr,A,visited);
    return res;
  }

  private static void recur(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr,
      ArrayList<Integer> A, boolean[] visited){
    if(curr.size()==A.size()){
      res.add(new ArrayList<>(curr));
      return;
    }
    for(int i=0;i<A.size();i++){
      if(visited[i]){
        continue;
      }
      if(i>0 && A.get(i)==A.get(i-1) && !visited[i-1]){
        continue;
      }
      curr.add(A.get(i));
      visited[i]=true;
      recur(res,curr,A,visited);
      visited[i]=false;
      curr.remove(curr.size()-1);
    }
  }
}
