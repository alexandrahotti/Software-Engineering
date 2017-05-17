   import java.io.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.net.*;
   import javax.swing.*;
   import javax.swing.event.*;
   import javax.swing.text.html.*;
   import javax.swing.text.*;

public class WebReader extends JEditorPane{

  JEditorPane webReader;

  WebReader(){
    super();
    setEditable(false);
    }
    public void showPage(String webAdress) throws IOException{
        this.setPage(webAdress);
    }
    public static void main(String args[]){
      WebReader webReader = new WebReader();
    }
}
