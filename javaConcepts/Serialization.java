package com.practiseJava.javaConcepts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

public class Serialization implements Serializable {

  @Serial
  private static final long serialVersionUID = 5307072235114980144L;

  public String name;
    public String company_name;
    public int emp_id;


    public static void main(String[] args) {
      Serialization e1 = new Serialization();
      e1.name = "Sk Elaf Ahmed";
      e1.company_name = "Siksha.com";
      e1.emp_id = 1;


      try {
        try (FileOutputStream fileOut = new FileOutputStream("C:\\coding_practice\\test1.txt")) {
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(e1);
          out.close();
        }

        System.out.println("Our data is serialized and saved in disk storage");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
