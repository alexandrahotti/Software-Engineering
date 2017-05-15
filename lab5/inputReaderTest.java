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
          sc = new Scanner(new File("Liv.xml"));
      }
      catch(FileNotFoundException e){
          System.out.println(e);
      }
}

public static void scan(){
  System.out.println(sc.hasNextLine());
  while(sc.hasNextLine()){
      line = sc.nextLine();
      //System.out.println(line);
  }
}

public static void main(String[]args){
  inputReaderTest scan = new inputReaderTest();
  scan();

}
}
