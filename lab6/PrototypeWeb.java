import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import java.io.IOException;


class PrototypeWeb{ // implements ActionListener{

JFrame frame;
JTable table;
JEditorPane editorpane;
JScrollPane leftlinks;
JLabel label;
JScrollPane rightlinks;

PrototypeWeb(){
  table = new JTable(50,2);
  rightlinks = new JScrollPane(table);
  frame =new JFrame();

  editorpane=new JEditorPane();
  leftlinks = new JScrollPane(editorpane);

  label= new JLabel();

  editorpane.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      try {
        String b =  editorPane.getText();
      } catch (IOException error) {
        System.err.println("Unable to load: " + error);
      }
    }
  });

  leftlinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  frame.setMinimumSize(new Dimension(700, 500));
  frame.add(label,BorderLayout.NORTH);
  frame.add(leftlinks,BorderLayout.CENTER);
  //frame.add(table,BorderLayout.EAST);
  frame.add(rightlinks,BorderLayout.EAST);
  frame.setVisible(true);



}

public static void main(String args[]){
  PrototypeWeb prototype = new PrototypeWeb();
}

}
