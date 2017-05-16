import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;

public class WebLinks{

String webPage = "http://www.nada.kth.se/~henrik";
InputStream in;
InputStreamReader reader;
HTMLEditorKit htmlKit;
HTMLDocument htmlDoc;

public void loadWebPage() throws IOException{
       System.out.println("Kom in i loadWebPage");
   try{
       in = new URL(webPage).openConnection().getInputStream();
       reader = new InputStreamReader(in);

       htmlKit = new HTMLEditorKit();
       htmlDoc = new HTMLDocument();

       htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
//       htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();

      // while(reader.ready()){
    //   System.out.println("Kom in i while loopen");
       System.out.println((char)reader.read());
       htmlKit.read(reader, htmlDoc, 0); //BadLocationException kopplat till read
       System.out.println(htmlDoc);
    //   }
   }
   catch(BadLocationException | IOException e){
       System.out.println("Failed to load web page.");
   }
}

public static void main(String[] args){
    WebLinks webLinks = new WebLinks();
    try{
        webLinks.loadWebPage();
    }
    catch(IOException e){
        System.out.println("Failed to load web page.");
    }

  }
}
