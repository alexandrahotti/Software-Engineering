//Alexandra Hotti & Helena Rosenzweig

import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TreeOfLife extends TreeFrame{

static String directory = "Liv";
static Scanner sc;

// used when reading input, and
// during recursion.
String line;
String level;
String name;
String text;

TreeOfLife(){
        super();
    }

// Overrides method in TreeFrame
void initTree() {
  initializeScanner();
  line = sc.nextLine(); //för att ta bort första konstiga raden
  String[] listNodes = readInputFile();
  level = listNodes[0];
  text = listNodes[1];
  name = listNodes[2];

  root = new MyNode(name,level,text);
  treeModel = new DefaultTreeModel(root);
  tree = new JTree(treeModel);
  while(sc.hasNextLine()){
    buildTree();
  }
}

 // Create scanner, x1
 private void initializeScanner(){
     try{
         sc = new Scanner(new File("Liv.xml"));
     }
     catch(FileNotFoundException e){
         System.out.println(e);
     }
 }

// Initiates recursive buildTree loop
private void buildTree() {
  level="";

// To avoid creating empty last file
    String[] listNodes2 = readInputFile();  // division, DÄGG
    level = listNodes2[0];
    text = listNodes2[1];
    name = listNodes2[2];

   while(sc.hasNextLine()&& !"Biosfär".equals(level)){
      buildTree(name, root, level, text);
      String[] listNodes = readInputFile();
      level = listNodes[0];
      text = listNodes[1];
      name= listNodes[2];
}
}

private void buildTree( String name, MyNode parent, String level, String text) {

      MyNode child = new MyNode(name, level, text);
      parent.add(child);

      // Look for child's children
       while (sc.hasNextLine() ){
             String[] listNodes = readInputFile();
             level = listNodes[0];
             text = listNodes[1];
             name= listNodes[2];
             // if new child found
             if(!child.level.equals(level)){
                buildTree(name, child, level, text);
              }
            // No child (was a leaf), look for sibbling
              else{
                 return;
               }
          }
     }

//Reads row from liv.xml file
private String[] readInputFile (){
      String [] nodeAttributes = new String[3];

      if(sc.hasNextLine()){
            line = sc.nextLine();

            String lineTemp = line.replaceAll("<", "");
            String linetemptemp=lineTemp;
            String character =linetemptemp.substring(0,1);

          // check if (for example): </Art>
            if(character.equals("/")){
                lineTemp = lineTemp.replaceAll("/", "");
                lineTemp = lineTemp.replaceAll(">", "");
                nodeAttributes[0] = lineTemp;
            }
          // read next level (for example): <Rike>
            else{
              // gets left section consisting of level-info
                String [] tokens = lineTemp.split(">");
                String levelSection = tokens[0];

              // text section complete
                String textSection = tokens[1];
                String [] levSecTokens =levelSection.split(" ");
                nodeAttributes[1] = textSection;

              // level section complete
                nodeAttributes[0] = levSecTokens[0];

             // name section
                String [] namesectemp = levSecTokens[1].split("=");
                name = namesectemp[1].replaceAll("\"", "");
                nodeAttributes[2] = name;
                }
      }
      else{
        return nodeAttributes;
      }
      return nodeAttributes;
  }


// Overrides method in TreeFrame
void showDetails(TreePath p){
      if (p==null){
          return;
      }
  //  gets selected Node
      MyNode f=(MyNode)p.getLastPathComponent();
      JOptionPane.showMessageDialog(this,f.getinfo()+"\n   ");//+getAttributes(f));
  }

public static void main(String[] args) {
    if(args.length>0){
        directory=args[0];
    }
    new TreeOfLife();
  }
}
