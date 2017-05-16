import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import java.io.IOException;


class PrototypeWeb implements ActionListener{

JFrame frame;
JTable table;
JEditorPane editorPane;
JScrollPane leftlinks;
//JLabel label;
JScrollPane rightlinks;
JTextField textField;
static String newline = "\n";

PrototypeWeb(){
  table = new JTable(50,2);
  rightlinks = new JScrollPane(table);
  frame =new JFrame();

  editorPane=new JEditorPane();
  leftlinks = new JScrollPane(editorPane);

  textField = new JTextField(20);
  //label= new JLabel();

  textField.addActionListener(this);

  leftlinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  frame.setMinimumSize(new Dimension(700, 500));
  frame.add(textField,BorderLayout.NORTH);
  frame.add(leftlinks,BorderLayout.CENTER);
  //frame.add(table,BorderLayout.EAST);
  frame.add(rightlinks,BorderLayout.EAST);
  frame.setVisible(true);
}

public void actionPerformed(ActionEvent evt) {
      String text = textField.getText();
//      textArea.append(text + newline);
      textField.selectAll();
      String url = textField.getSelectedText();
      if (url != null) {
          try {
              editorPane.setPage(url);
          } catch (IOException e) {
              System.err.println("Attempted to read a bad URL: " + url);
          }
      } else {
          System.err.println("Couldn't find file: TextSamplerDemoHelp.html");
      }


    //  return textField.getSelectedText();
}

public static void main(String args[]){
  PrototypeWeb prototype = new PrototypeWeb();
}

}
