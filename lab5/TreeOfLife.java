import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TreeOfLife extends TreeFrame{

static String directory = "Liv";
static Scanner sc;
String line;
String level;
String name;
String text;

TreeOfLife(){
        super();
//        attributes = new ArrayList<MyNode>;
    }
// Overrides method in TreeFrame
void initTree() {
  //System.out.println("i initTree");
  initializeScanner();
  line = sc.nextLine(); //för att ta bort första konstiga raden
  String[] listNodes = readInputFile();
  level = listNodes[0];
  text = listNodes[1];
  name = listNodes[2];
  //System.out.println(level+" level root");
  root = new MyNode(name,level,text);                   // DJUR SKAPAS
  treeModel = new DefaultTreeModel(root);
  tree = new JTree(treeModel);
  buildTree();
}

 private void initializeScanner(){
     //System.out.println("i initializeScanner");
     try{
         sc = new Scanner(new File("Liv.xml"));
         //System.out.println("skapade en scanner");
     }
     catch(FileNotFoundException e){
         System.out.println(e);
     }
 }

// New method
private void buildTree() {
    String[] listNodes2 = readInputFile();  //rike växter
    level = listNodes2[0];
    text = listNodes2[1];
    name = listNodes2[2];
    //System.out.println(name+" name child");

  //while(level!=root.level){
      buildTree(name, root, level, text);
    //}
}

// New method
private void buildTree( String name, MyNode parent, String level, String text) {

     MyNode child = new MyNode(name, level, text);                  // division och kryptogamer
      parent.add(child); //detta skriver över det förra barnet      // KOPPLAR PÅ DÄGGDJUR
      //System.out.println("buildtree2; namn på nod "+name);
      //System.out.println(sc.hasNextLine() );


      //child = division

       if (sc.hasNextLine() ){
         //System.out.println("kom in!");
             String[] listNodes = readInputFile();
             level = listNodes[0];
             text = listNodes[1];
             name= listNodes[2];
             System.out.println(level+" level");
             if(child.level!=level){
              // String[] listNodes = readInputFile();
                // level = listNodes[0];
                // text = listNodes[1];
                // name= listNodes[2];
                // System.out.println(" name child "+name);
                // System.out.println(" level child "+level);

                buildTree(name, child, level, text);    //    DETTA FÖR ATT SKAPA CHIMP
              }
              else{
                buildTree(name, (MyNode)child.getParent(), level, text);
              }
          }
     }

//Biosfär-Rike-Division-Klass-Familj-Art
private String[] readInputFile (){
      //System.out.println("kom in in readInputFile");
      String [] nodeAttributes = new String[3];

      if(sc.hasNextLine()){
      //System.out.println("has new line ");
      line = sc.nextLine();
      //System.out.println(line+" lineeeeeeeeeeeeeee");

      String lineTemp = line.replaceAll("<", "");
      //System.out.println(lineTemp+"line efter borttagning av <");
      String linetemptemp=lineTemp;
      String character =linetemptemp.substring(0,1);
      if(character.equals("/")){  //isf var det en leaf
          lineTemp = lineTemp.replaceAll("/", "");
          lineTemp = lineTemp.replaceAll(">", "");
          nodeAttributes[0] = lineTemp;
      }
      else{
          //System.out.println(line+" lineeeeeeeeeeeeeee");
          String [] tokens = lineTemp.split(">");

          //System.out.println(tokens[0]+" tokens[0]");
          String levelSection = tokens[0];
          String textSection = tokens[1];
          String [] levSecTokens =levelSection.split(" ");
          nodeAttributes[0] = levSecTokens[0];
          nodeAttributes[1] = textSection;

          String [] namesectemp = levSecTokens[1].split("=");
          name = namesectemp[1].replaceAll("\"", "");
          nodeAttributes[2] = name;
          // System.out.println();
          // System.out.println(nodeAttributes[2]+" nodeAttributes[2]");
          // System.out.println(nodeAttributes[1]+" nodeAttributes[1]");
          // System.out.println(nodeAttributes[0]+" nodeAttributes[0]");
      }
    }
      else{
        //System.out.println("inte härrrrrrrrrrrrrrrrrr");
        return nodeAttributes;
      }
      //System.out.println("return blev korrekt");
      return nodeAttributes;
  }


// Overrides method in TreeFrame
void showDetails(TreePath p){
      if (p==null){
          return;
      }
    // Abstract representation of file and directory path names
      File f = new File(p.getLastPathComponent().toString());
      JOptionPane.showMessageDialog(this,f.getPath()+"\n   "+getAttributes(f));
  }

// New method
private String getAttributes(File f) {
     String t ="";
  //     t +=f.toString();
  //     if(t==)
  //
  //
  // else {
  //     t += "Contains files: \n     ";
  //     String[ ] contents = f.list();
  //     for ( int i = 0; i < contents.length; i++ )
  //       t += contents[i] + ", ";
  //         t += "\n";
  //     }
    return t;
}


public static void main(String[] args) {
    if(args.length>0){
        directory=args[0];
    }
    new TreeOfLife();
}

}
