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
static InputStream in;
static InputStreamReader reader;
HTMLEditorKit htmlKit;
HTMLDocument htmlDoc;

WebLinks(){
    htmlKit = new HTMLEditorKit();
}

public void loadWebPage() throws IOException{
       in = new URL(webPage).openConnection().getInputStream();
       reader = new InputStreamReader(in);
       htmlKit = new HTMLEditorKit();
       htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
       htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
       while(reader.ready()){
           try{
               htmlKit.read(reader, htmlDoc, 0);
           }
           catch(BadLocationException | IOException e){
               System.out.println("Failed to load web page.");
           }
      }
}

public static void main(String[] args){
    WebLinks webLinks = new WebLinks();
    webLinks.loadWebPage();
    }
}
