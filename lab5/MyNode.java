import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;

public class MyNode extends DefaultMutableTreeNode{

    String level;
    String text;
    String name;

    MyNode(String name, String level, String text){
        super();
        this.level = level;
        this.text = text;
        this.name=name;
    }

    public String toString(){
      return this.name;
    }
}
