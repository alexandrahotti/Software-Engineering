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
import java.util.ArrayList;
import javax.swing.JButton;

class WebView implements ActionListener{

JFrame frame;
JTable table;
WebReader webReader;
JScrollPane leftLinks;
JScrollPane rightLinks;
JTextField textField;
JOptionPane dialogueBox;
String [] header;
String webPage;// = "http://www.nada.kth.se/~snilsson"; //"http://www.nada.kth.se/~henrik";
WebModel webModel;
JButton forward;
JButton backward;
int currentIndex;
JPanel buttonPanel;

JButton saveBookMark;
JButton handleBookMarks;
JOptionPane nameDialogueBox;
JOptionPane dialogueBoxBookMarks;
BookMarkLibrary  bookMarkLibrary;
ArrayList<String> visitedLinks;

WebView(){

      table = new JTable(50,2);
      rightLinks = new JScrollPane(table);
      frame =new JFrame();
      header = new String[2];
      header[0] = "ADRESS";
      header[1] ="BENÄMNING";
      webModel = new WebModel();
      webReader=new WebReader();
      bookMarkLibrary = new BookMarkLibrary();

      saveBookMark = new JButton();
      handleBookMarks = new JButton();

      saveBookMark.setText("SAVE BOOKMARK");
      handleBookMarks.setText("HANDLE BOOKMARKS");

      saveBookMark.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          bookMarkLibrary.addBookMark(enterName(), textField.getText());
        }
      } );

      handleBookMarks.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          bookMarkLibrary.removeBookMark(removeName());
        }
      } );

      webReader.addHyperlinkListener(new HyperlinkListener() {
          public void hyperlinkUpdate(HyperlinkEvent e) {
              if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                visitedLinks.add(e.getURL().toString());
                currentIndex ++;
                updatepage(e.getURL().toString());
                textField.setText(e.getURL().toString());
        }
    }
});

      buttonPanel = new JPanel();
      forward = new JButton();
      backward = new JButton();
      forward.setText("FORWARD");
      backward.setText("BACKWARD");
      visitedLinks = new ArrayList();

      forward.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          selectionButtonPressed(forward,e.getActionCommand());
        }
      } );

      backward.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          selectionButtonPressed(backward,e.getActionCommand());
        }
      } );

      leftLinks = new JScrollPane(webReader);
      textField = new JTextField(20);

      textField.addActionListener(this);

      System.out.println("den kommer ändå hit");
      buttonPanel.add(backward,BorderLayout.WEST);
      buttonPanel.add(forward,BorderLayout.EAST);
      buttonPanel.add(saveBookMark, BorderLayout.EAST);
      buttonPanel.add(handleBookMarks, BorderLayout.EAST);

      leftLinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      frame.setMinimumSize(new Dimension(700, 500));
      frame.add(textField,BorderLayout.NORTH);
      frame.add(leftLinks,BorderLayout.CENTER);
      frame.add(rightLinks,BorderLayout.EAST);
      frame.add(buttonPanel, BorderLayout.SOUTH);

      frame.setVisible(true);
    }

public String enterName(){
    return nameDialogueBox.showInputDialog(frame, "Name your book mark:");
}

public String removeName(){
    return dialogueBoxBookMarks.showInputDialog(frame, "Enter the name of the book mark you want to delete:");
}

public void updatepage(String url){
  try{
      // calls method loadWebPage and loads table with URL links and tags
      table.setModel(new DefaultTableModel(webModel.loadWebPage(url), header));
      webReader.showPage(url);

  }
  catch(IOException e){
      // displays dialogueBox in case invalid url was entered
      dialogueBox.showMessageDialog(frame, "Invalid URL adress");
  }
}

public void selectionButtonPressed(JButton button, String command){
    System.out.println(currentIndex);
    int numberOfIndexes = visitedLinks.size()-1;
    if(visitedLinks.isEmpty()){
        dialogueBox.showMessageDialog(frame, "can't go "+command);
    }
    else{
          if(command.equals("FORWARD")){
              if(currentIndex < numberOfIndexes){
                  currentIndex = currentIndex + 1;
                  String url = visitedLinks.get(currentIndex);
                  updatepage(url);

              }
              else{
              dialogueBox.showMessageDialog(frame, "can't go "+command);
              }
          }
          else if(command.equals("BACKWARD")){
              if (currentIndex>0){
                  currentIndex = currentIndex-1;
                  String url = visitedLinks.get(currentIndex);
                  updatepage(url);
                  currentIndex = currentIndex --;
              }
              else{
              dialogueBox.showMessageDialog(frame, "can't go "+command);
              }
            }
          }
        }

// Listens after user to press "ENTER"
public void actionPerformed(ActionEvent evt) {
      String url = textField.getText();
      if (url != null){
        updatepage(url);
        visitedLinks.add(url);
        currentIndex ++;
     }
     else{
     }
}

public static void main(String args[]){
      System.out.println("i main");
      WebView webView = new WebView();
}

}
