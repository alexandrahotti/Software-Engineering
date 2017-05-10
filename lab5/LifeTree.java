import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;

//  FÖRBEREDELSEUPPGIFT

public class LifeTree extends TreeFrame{

    static String directory="Liv";
    DefaultMutableTreeNode child1;
    DefaultMutableTreeNode child2;
    DefaultMutableTreeNode child3;

    LifeTree(){
        super();

    }

    void initTree() {
     	root = new DefaultMutableTreeNode(directory);

    	treeModel = new DefaultTreeModel(root);
    	tree = new JTree(treeModel);
    	buildTree();
    }


    private void buildTree() {
    //  File f=new File(directory);
    //  String[] list = f.list();
    //  for (int i=0; i<list.length; i++){
        buildTree(root);
  //  }
}
  // Recursive metod adds children
    private void buildTree(DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Växter");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Djur");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Svampar");

        parent.add(child1);
        parent.add(child2);
        parent.add(child3);

        // if (f.isDirectory())
        //     String list[] = f.list();
        //     for (int i=0; i < list.length; i++){
        //         buildTree(new File(f,list[i]), child);
        //   }

  }

    // Overrides method in TreeFrame
    void showDetails(TreePath p){
    if (p == null){
        return;
    }
    File f = new File(p.getLastPathComponent().toString());
    JOptionPane.showMessageDialog(this, f.getPath() +"\n   " + getAttributes(f));
}

    // New method
    private String getAttributes( File f ) {
      String t = "";
      if (f.isDirectory()){
          t += "Directory";
        }
      else{
          t += "Nondirectory file";
      t += "\n   ";
       }
      if (!f.canRead()){
          t += "not ";
          t += "Readable\n   ";
      }
      if (!f.canWrite()){
          t += "not ";
          t += "Writeable\n  ";
      }
      if (!f.isDirectory()){
          t += "Size in bytes: " + f.length() + "\n   ";
      }
      else {
          t += "Contains files: \n     ";
          String[ ] contents = f.list();
          for(int i = 0; i < contents.length; i++){
              t += contents[i] + ", ";
              t += "\n";
      }

    }
    return t;
  }

    public static void main(String[] args) {
      if(args.length>0) directory=args[0];
      new LifeTree();
    }
}
