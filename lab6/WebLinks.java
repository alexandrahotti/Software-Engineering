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

      // while(reader.ready())
    //   System.out.println("Kom in i while loopen");
       System.out.println((char)reader.read());
       // Lägger in inputStream i ett html dokument
       htmlKit.read(reader, htmlDoc, 0); //BadLocationException kopplat till read
  //     System.out.println(htmlDoc);


       for(HTMLDocument.Iterator htmlIterator = htmlDoc.getIterator(HTML.Tag.A); htmlIterator.isValid(); htmlIterator.next()){
              AttributeSet attributes = htmlIterator.getAttributes();
              String attributesHREF = (String) attributes.getAttribute(HTML.Attribute.HREF);
  			      System.out.println(attributesHREF);
       }
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
