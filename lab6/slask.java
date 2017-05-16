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
String [][] outputMatrix;
int elements=0;
int rowIndex = 0;
int columnIndex = 0;

public String [][] loadWebPage() throws IOException{

   try{
       in = new URL(webPage).openConnection().getInputStream();
       reader = new InputStreamReader(in);

       htmlKit = new HTMLEditorKit();
       htmlDoc = new HTMLDocument();

       outputMatrix = new String [50][2];

       htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
  //     htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();

       System.out.println((char)reader.read());
       // Lägger in inputStream i ett html dokument
       htmlKit.read(reader, htmlDoc, 0); //BadLocationException kopplat till read
  //     System.out.println(htmlDoc);

       for(HTMLDocument.Iterator htmlIterator = htmlDoc.getIterator(HTML.Tag.A); htmlIterator.isValid(); htmlIterator.next()){
              AttributeSet attributes = htmlIterator.getAttributes();
              String attributesHREF = (String) attributes.getAttribute(HTML.Attribute.HREF);

              if(elements!=100){
                  if(rowIndex==49){
                      rowIndex = 0;
                      columnIndex++;
                      System.out.println("Byter till andra kolumnen");
                  }
                  if (columnIndex == 0){
                      outputMatrix[rowIndex][columnIndex] = attributesHREF;
                      elements ++;
                      rowIndex ++;
                      System.out.println("kommer HIT");
                      System.out.println("rowIndex är: "+ rowIndex);
                      System.out.println("columnIndex är: "+ columnIndex);
                  }
              }

              int startOffset = htmlIterator.getStartOffset();
              int endOffset = htmlIterator.getEndOffset();
              int length = endOffset - startOffset;
              String text = htmlDoc.getText(startOffset, endOffset);

              System.out.println("Ska in i loopen");
    //          System.out.println(attributesHREF);
    //          System.out.println(text);

                  if(columnIndex==1){
                      System.out.println("kommer hiiiiiiiiiiit");
                      outputMatrix[rowIndex][columnIndex] = text;
                      elements ++;
                      rowIndex ++;
                  }
  //            System.out.println(" - " + text);

  //      System.out.println(attributesHREF);

//		    System.exit(0);

   }
 }
   catch(BadLocationException | IOException e){
       System.out.println("Failed to load web page.");
   }
  return outputMatrix;
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
