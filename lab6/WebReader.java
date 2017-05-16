   import java.io.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.net.*;
   import javax.swing.*;
   import javax.swing.event.*;
   import javax.swing.text.html.*;
   import javax.swing.text.*;


public class WebReader extends JEditorPane implements ActionListener{

  JFrame frame;
  JTable table;
  JEditorPane editorPane;
  JScrollPane leftLinks;
  JOptionPane dialogueBox;
  JScrollPane rightLinks;
  JTextField textField;

  WebReader(){
    table = new JTable(50,2);
    rightLinks = new JScrollPane(table);
    frame =new JFrame();

    editorPane=new JEditorPane();
    leftLinks = new JScrollPane(editorPane);

    textField = new JTextField(20);

    dialogueBox = new JOptionPane();

      editorPane.setEditable(false);
      textField.addActionListener(this);

      leftLinks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      frame.setMinimumSize(new Dimension(700, 500));
      frame.add(textField,BorderLayout.NORTH);
      frame.add(leftLinks,BorderLayout.CENTER);
      //frame.add(table,BorderLayout.EAST);
      frame.add(rightLinks,BorderLayout.EAST);
      frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
          String url = textField.getText();
          if (url != null){
              try{
                  showPage(url);
              }
              catch(IOException e){
                  dialogueBox.showMessageDialog(frame, e.getMessage());
              }
          }
          else{
              System.err.println("Couldn't find file: TextSamplerDemoHelp.html");
          }
    }

    public void showPage(String webAdress){
        editorPane.setPage(webAdress);
    }

    public static void main(String args[]){
      WebReader webReader = new WebReader();
    }
}
