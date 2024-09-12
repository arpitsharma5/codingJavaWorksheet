package com.practiseJava.StacknQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
* */
public class GenerateValidParenthesis {

  public static void main(String[] args) {
    List<String> res = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    backtrack(2, 0, 0, stack, res);
    System.out.println(res);
  }

  private static void backtrack(int n, int openN, int closedN, Stack<Character> stack, List<String> res) {
    if(openN < n) {
      stack.push('(');
      backtrack(n, openN+1, closedN, stack, res);
      stack.pop();
    }
    if(closedN < openN) {
      stack.push(')');
      backtrack(n, openN, closedN+1, stack, res);
      stack.pop();
    }
    if(openN == closedN && openN == n) {
      StringBuilder sb = new StringBuilder();
      for(var s: stack) {
        sb.append(s);
      }
      res.add(sb.toString());
    }
  }
}
