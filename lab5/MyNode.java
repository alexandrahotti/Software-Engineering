import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;

public class MyNode extends DefaultMutableTreeNode{

    String level;
    String text;

    MyNode(String name, String level, String text){
        super(name);
        this.level = level;
        this.text = text;
    }
}
