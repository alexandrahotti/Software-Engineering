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
WebReader webReader;
JScrollPane leftLinks;
JScrollPane rightLinks;
JTextField textField;
JOptionPane dialogueBox;
static String newline = "\n";

// Påbörjar "Använd matrisen i huvudprogrammet"-delen

PrototypeWeb(){
  table = new JTable(50,2);
  rightLinks = new JScrollPane(table);
  frame =new JFrame();

  webReader=new WebReader();
  leftLinks = new JScrollPane(webReader);
  textField = new JTextField(20);
  //label= new JLabel();

  textField.addActionListener(this);

  leftLinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  frame.setMinimumSize(new Dimension(700, 500));
  frame.add(textField,BorderLayout.NORTH);
  frame.add(leftLinks,BorderLayout.CENTER);
//  frame.add(table,BorderLayout.EAST);
  frame.add(rightLinks,BorderLayout.EAST);
  frame.setVisible(true);
}

public void actionPerformed(ActionEvent evt) {
      String url = textField.getText();
      if (url != null){
          try{
              webReader.showPage(url);
          }
          catch(IOException e){
              dialogueBox.showMessageDialog(frame, "Invalid URL adress: " + url);
          }
      }
      else{
          System.err.println("Couldn't find file: TextSamplerDemoHelp.html");
      }
}

public static void main(String args[]){
  PrototypeWeb prototype = new PrototypeWeb();
}

}
