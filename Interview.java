package com.practiseJava;

/*
* input = "ABCDEFGH"

output = "BDFHGECA"
* */
public class Interview {
  public static void main(String []args) {
    System.out.println(convert("ABCDEFGH"));

  }

  private static String convert(String inp) {
    StringBuilder res1 = new StringBuilder();
    StringBuilder res2 = new StringBuilder();
    int len = inp.length();
    for(int i = 0; i < len; i++) {
      if(i % 2 != 0) {
        res1.append(inp.charAt(i));
      } else {
        res2.append(inp.charAt(i));
      }
    }
    return res1.toString().concat(res2.reverse().toString());
  }
}
