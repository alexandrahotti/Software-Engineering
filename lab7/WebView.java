//
//    Authors:
//    Helena Rosenzweig & Alexandra Hotti
//    DD2385: Lab assignment 7
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

JButton visitBookMark;
JButton saveBookMark;
JButton removeBookMarks;
JOptionPane nameDialogueBox;
JOptionPane dialogueBoxBookMarks;
BookMarkLibrary  bookMarkLibrary;
ArrayList<String> visitedLinks;

WebView(){

      /*  WINDOW GRAPHICS  */
      table = new JTable(50,2);
      rightLinks = new JScrollPane(table);
      frame =new JFrame();
      header = new String[2];
      header[0] = "ADRESS";
      header[1] ="BENÄMNING";

      /*  INITIATE MODELS  */
      bookMarkLibrary = new BookMarkLibrary();
      webModel = new WebModel();
      webReader=new WebReader();
      visitedLinks = new ArrayList();
      leftLinks = new JScrollPane(webReader);
      textField = new JTextField(20);

      /*  BUTTON GRAPHICS  */
      buttonPanel = new JPanel();
      forward = new JButton();
      backward = new JButton();
      forward.setText("FORWARD");
      backward.setText("BACKWARD");

      /*  BOOKMARK GRAPHICS  */
      visitBookMark = new JButton();
      saveBookMark = new JButton();
      removeBookMarks = new JButton();
      visitBookMark.setText("GO TO");
      saveBookMark.setText("SAVE");
      removeBookMarks.setText("REMOVE");

      /*  FRAME ACTIONLISTENER: close on exit  */
      frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
          System.exit(0);
        }
      });

      /*  SAVE-BOOKMARK ACTIONLISTENER: saves bookmark  */
      saveBookMark.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if(visitedLinks.isEmpty()){
              dialogueBox.showMessageDialog(frame, "   This is an invalid website.\n You can't book mark this page!");
          }
          else{
          bookMarkLibrary.addBookMark(enterName(), textField.getText());
        }
        }
      });

      /*  VISIT-BOOKMARK ACTIONLISTENER: visits a saved bookmark  */
      visitBookMark.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try{
              String bookMarkName = visitSavedBookMark();
              for(int i = 0; i < bookMarkLibrary.bookMarks.size(); i++){
                  if(bookMarkLibrary.bookMarks.get(i).name.equals(bookMarkName)){
                      BookMark bookMark = bookMarkLibrary.bookMarks.get(i);
                      webReader.showPage(bookMark.url);
                    }
                }
            }
            catch(IOException | NullPointerException | ArrayIndexOutOfBoundsException error){
                  dialogueBox.showMessageDialog(frame, "No previously saved book marks.");
            }
        }
      });

      /*  REMOVE-BOOKMARK ACTIONLISTENER: removes bookmark  */
      removeBookMarks.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if(bookMarkLibrary.bookMarks.size()>0){
              bookMarkLibrary.removeBookMark(removeName());
          }
          else{
              dialogueBox.showMessageDialog(frame, "No book marks to delete.");
          }
        }
      } );

      /*  WEBREADER ACTIONLISTENER: makes links clickable  */
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

      /*  FORWARD ACTIONLISTENER: moves to "foward" url  */
      forward.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          selectionButtonPressed(forward,e.getActionCommand());
        }
      } );

      /*  FORWARD ACTIONLISTENER: moves to "backward" url  */
      backward.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          selectionButtonPressed(backkena ska lagras sorterade eller sorteras på användarens begäran. ward,e.getActionCommand());
        }
      } );

      /* textField ACTIONLISTENER, will evoke actionPerformed method  */
      textField.addActionListener(this);

      /* A whole lot of adding graphical elements :) */
      buttonPanel.add(backward,BorderLayout.WEST);
      buttonPanel.add(forward,BorderLayout.EAST);
      buttonPanel.add(saveBookMark, BorderLayout.EAST);
      buttonPanel.add(removeBookMarks, BorderLayout.EAST);
      buttonPanel.add(visitBookMark, BorderLayout.EAST);
      leftLinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      frame.setMinimumSize(new Dimension(700, 500));
      frame.add(textField,BorderLayout.NORTH);
      frame.add(leftLinks,BorderLayout.CENTER);
      frame.add(rightLinks,BorderLayout.EAST);
      frame.add(buttonPanel, BorderLayout.SOUTH);

      /*  YEY! Make it visible!  */
      frame.setVisible(true);

}

/*      ******      ~~~~ END OF CONSTRUCTOR  ~~~~     ******       */


//  Takes in userinput for naming bookMark, input is collected
//  using a dialogueBox:
public String enterName(){
    return nameDialogueBox.showInputDialog(frame, "Name your book mark:");
}

// Takes in userinput for what bookMark to delete, this interaction
//  occurs via a dialogueBox:
public String removeName(){
    String [] bookMarkNames = new String[bookMarkLibrary.bookMarks.size()];
    bookMarkLibrary.sortBookMarks();
    for(int i = 0; i<bookMarkLibrary.bookMarks.size(); i++){
        bookMarkNames[i] = bookMarkLibrary.bookMarks.get(i).name;
    }
        String s = (String) dialogueBoxBookMarks.showInputDialog(
                                                 frame,
                                                 "Which book mark do you want to delete?",
                                                 "Display book marks",
                                                 dialogueBoxBookMarks.QUESTION_MESSAGE,
                                                 null,
                                                 bookMarkNames,
                                                 bookMarkNames[0]);
        return s;
}

//  Allows the user to visit a webpage that has previously
//  been saved as a bookMarks. Choice is made via a dialogueBox:
public String visitSavedBookMark(){
    String [] bookMarkNames = new String[bookMarkLibrary.bookMarks.size()];
    bookMarkLibrary.sortBookMarks();
    for(int i = 0; i<bookMarkLibrary.bookMarks.size(); i++){
        bookMarkNames[i] = bookMarkLibrary.bookMarks.get(i).name;
    }
        String s = (String) dialogueBoxBookMarks.showInputDialog(
                                                 frame,
                                                 "Which book mark do you want to visit?",
                                                 "Display book marks",
                                                 dialogueBoxBookMarks.QUESTION_MESSAGE,
                                                 null,
                                                 bookMarkNames,
                                                 bookMarkNames[0]);
        return s;
}

// Updates webpage:
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

// Handles backward and forward traversal between previously
// visited web pages:
public void selectionButtonPressed(JButton button, String command){
    System.out.println(currentIndex);
    int numberOfIndexes = visitedLinks.size()-1;
    if(visitedLinks.isEmpty()){
        dialogueBox.showMessageDialog(frame, "can't go "+command);
    }
    else{
          if(command.equals("FORWARD")){
              if(currentIndex <= numberOfIndexes){
                  currentIndex = currentIndex + 1;
                  String url = visitedLinks.get(currentIndex-1);
                  updatepage(url);

              }
              else{
              dialogueBox.showMessageDialog(frame, "can't go "+command);
              }
          }
          else if(command.equals("BACKWARD")){
              if (currentIndex>1){
                  currentIndex = currentIndex-1;
                  String url = visitedLinks.get(currentIndex-1);
                  System.out.print("url: ");
                  System.out.println(url);
                  updatepage(url);
              }
              else{
              dialogueBox.showMessageDialog(frame, "can't go "+command);
              }
            }
          }
        }

// Listens after user to press "ENTER":
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

// Initiates window and program:
public static void main(String args[]){
      System.out.println("i main");
      WebView webView = new WebView();
}

}
