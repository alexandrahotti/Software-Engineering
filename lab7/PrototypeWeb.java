//
//    Authors:
//    Helena Rosenzweig & Alexandra Hotti
//
//

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import java.io.IOException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class PrototypeWeb implements ActionListener{

JFrame frame;
JTable table;
WebReader webReader;
JScrollPane leftLinks;
JScrollPane rightLinks;
JTextField textField;
JOptionPane dialogueBox;
String [] header;
String webPage;// = "http://www.nada.kth.se/~snilsson"; //"http://www.nada.kth.se/~henrik";
WebLinks webLinks;

PrototypeWeb(){
      table = new JTable(50,2);
      rightLinks = new JScrollPane(table);
      frame =new JFrame();
      header = new String[2];
      header[0] = "ADRESS";
      header[1] ="BENÄMNING";

      webReader=new WebReader();
      webReader.addHyperlinkListener(new HyperlinkListener() {
          public void hyperlinkUpdate(HyperlinkEvent e) {
              if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try{
                  webReader.setPage(e.getURL()); // Do something with e.getURL() here
                }
                catch(IOException error){
                    // displays dialogueBox in case invalid url was entered
                    dialogueBox.showMessageDialog(frame, "Invalid URL adress");
                }
        }
    }
});

      leftLinks = new JScrollPane(webReader);
      textField = new JTextField(20);
      webLinks = new WebLinks();

      textField.addActionListener(this);

      leftLinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      frame.setMinimumSize(new Dimension(700, 500));
      frame.add(textField,BorderLayout.NORTH);
      frame.add(leftLinks,BorderLayout.CENTER);
      frame.add(rightLinks,BorderLayout.EAST);
      frame.setVisible(true);
    }

// Listens after user to press "ENTER"
public void actionPerformed(ActionEvent evt) {
      String url = textField.getText();
      if (url != null){
          try{
              // calls method loadWebPage and loads table with URL links and tags
              table.setModel(new DefaultTableModel(webLinks.loadWebPage(url), header));
              webReader.showPage(url);
          }
          catch(IOException e){
              // displays dialogueBox in case invalid url was entered
              dialogueBox.showMessageDialog(frame, "Invalid URL adress");
          }
     }
}

public static void main(String args[]){
      PrototypeWeb prototype = new PrototypeWeb();
}

}
