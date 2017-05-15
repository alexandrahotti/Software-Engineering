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
  System.out.println("i initTree");
  initializeScanner();

  String[] listNodes = readInputFile();
  level = listNodes[0];
  text = listNodes[1];
  name = listNodes[2];
  root = new MyNode(name,level,text);
  treeModel = new DefaultTreeModel(root);
  tree = new JTree(treeModel);
  buildTree();
}

 private void initializeScanner(){
     System.out.println("i initializeScanner");
     try{
         sc = new Scanner(new File("Liv.txt"));
         System.out.println("skapade en scanner");
     }
     catch(FileNotFoundException e){
         System.out.println(e);
     }
 }

// New method
private void buildTree() {
    //File f = new File(directory);
    String[] listNodes = readInputFile();
    level = listNodes[0];
    text = listNodes[1];
    name = listNodes[2];
    MyNode  f = new MyNode(name, level, text);
    //String[] list = f.list();
    System.out.println("i build Tree, ska in i readInputFile");
    String[] listNodes2 = readInputFile();
    String level = listNodes[0];
    String text = listNodes[1];
    String name = listNodes[2];
    //for (int i=0; i<list.length; i++){
        buildTree(name, root, level, text);

}

// New method
private void buildTree( String name, MyNode parent, String level, String text) {
      MyNode child = new MyNode(name, level, text);
      parent.add(child);
      // if (f.isDirectory()) {
      //       String list[] = f.list();

            while(child.level!=level){
                String[] listNodes = readInputFile();
                level = listNodes[0];
                text = listNodes[1];
                name= listNodes[2];
                // if (level.equals("false")){
                //   break;
                // }
                //for ( int i = 0; i < list.length; i++){
                      buildTree(name, child, level, text);
                //}
       }

}

//Biosfär-Rike-Division-Klass-Familj-Art
private String[] readInputFile (){

      String [] nodeAttributes = new String[3];

      if(sc.hasNextLine()){
      line = sc.nextLine();
      System.out.println(line);
      }
      else{
        return nodeAttributes;
      }
      String lineTemp = line.substring(1); //tar bort <
      String linetemptemp=lineTemp;
      String character =linetemptemp.substring(0);
      if(character.equals("/")){  //isf var det en leaf
          lineTemp = lineTemp.substring(1);
          lineTemp = lineTemp.replaceAll(">", "");
          nodeAttributes[3] = lineTemp;
      }
      else{
          String [] tokens = line.split(">");
          String levelSection = tokens[0];
          String textSection = tokens[1];
          String [] levSecTokens =levelSection.split(" ");
          nodeAttributes[0] = levSecTokens[0];
          nodeAttributes[1] = textSection;

          String [] namesectemp = levSecTokens[1].split("=");
          //String namesectemp2=namesectemp[1];
          String name = namesectemp[1].replaceAll("\"", "");
          nodeAttributes[2] = name;
      }
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
