import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;

public class TreeOfLife extends TreeFrame{

static ArrayList attributes;

TreeOfLife(){
        super();
        attributes = new ArrayList<MyNode>;
    }

static String directory = "Liv";

// Overrides method in TreeFrame
void initTree() {
  root = new MyNode(directory);
  treeModel = new MyNode(root);
  tree = new JTree(treeModel);
  buildTree();
}

// New method
private void buildTree() {
    File f = new File(directory);
    String[] list = f.list();
    for (int i=0; i<list.length; i++){
        buildTree(new File(f,list[i]), root);
    }
}

// New method
private void buildTree( File f, MyNode parent) {
      MyNode child = new MyNode(f.toString());
      parent.add(child);
      if (f.isDirectory()) {
            String list[] = f.list();
            for ( int i = 0; i < list.length; i++){
                  buildTree(new File(f,list[i]), child);
            }
       }
  }

Biosfär-Rike-Division-Klass-Familj-Art

// Overrides method in TreeFrame
void showDetails(TreePath p){
      if (p==null){
          return;
      }
    // Abstract representation of file and directory path names
      File f = new File(p.getLastPathComponent());
      JOptionPane.showMessageDialog(this,f.toString().getPath()+"\n   "+getAttributes(f));
  }

// New method
private String getAttributes(File f) {
      String t = "";
      t+=f.level+"\n"+f.text;
      return t;
  }

private ArrayList readInputFile (MyNode root){
    try{
        static Scanner sc = new Scanner(new File("Liv.txt"));
    }
    catch(FileNotFoundException e){
        System.out.println(e);
    }

    while(sc.hasNextLine()){
      String line = sc.nextLine();
      String lineTemp = line.subString(1);

      if(lineTemp.charAt(0).equals("/")){
          return;
}


      else{

        String [] tokens = line.split(">");
        String levelSection = tokens[0];
        String textSection = tokens[1];

        String [] levsectokens =levelSection.split(" ");
        MyNode nod =MyNode(levsectokens[0],textSection);
          }
        }

}
        for(char character: line){
            if(character = )
        }
    }
    attributes[]

    for rad in ("bla.txt"){
        arraylist;
    }
    return attributes;
}


public static void main(String[] args) {
    if(args.length>0){
        directory=args[0];
    }
    new TreeOfLife();
}

}
