import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class inputReaderTest{

static Scanner sc;
static String line;

  inputReaderTest(){
      try{
          sc = new Scanner(new File("Liv.txt"));
      }
      catch(FileNotFoundException e){
          System.out.println(e);
      }
}


public static void scan(){
  while(sc.hasNextLine()){
      line = sc.nextLine();
      System.out.println("hej");
  }
}

public static void main(String[]args){
  inputReaderTest scan = new inputReaderTest();
  scan();

}
}
