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
import java.util.ArrayList;

public class WebLinks{

String webPage;// = "http://www.nada.kth.se/~henrik";
InputStream in;
InputStreamReader reader;
HTMLEditorKit htmlKit;
HTMLDocument htmlDoc;
String [][] outputMatrix;
ArrayList<String> adresses;
ArrayList<String> texts;
int i=0;

// loads web page from user input
public String [][] loadWebPage(String webPage) throws IOException{
    try{
       in = new URL(webPage).openConnection().getInputStream();
       reader = new InputStreamReader(in, "UTF-8");

       htmlDoc = new HTMLDocument();
       htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

       // creates htmlKit object that reads html, and stores it in htmlDoc
       htmlKit = new HTMLEditorKit();
       htmlKit.read(reader, htmlDoc, 0);

       // creates output matrix, that will store URL and tags
       outputMatrix = new String [50][2];

       // creates arrays that will temporarily store URL and tags, before
       // placing them in outputMatrix
       adresses = new ArrayList<>();
       texts = new ArrayList<>();

       // creates iterator object that will iterator over content in htmlDoc, looking for Tag.A
       HTMLDocument.Iterator htmlIterator = htmlDoc.getIterator(HTML.Tag.A);

       while(htmlIterator.isValid()){
            //htmlKit.read(reader, htmlDoc,0);
              int startOffset = htmlIterator.getStartOffset();
			        int endOffset = htmlIterator.getEndOffset();
			        int length = endOffset - startOffset;

              String text = htmlDoc.getText(startOffset, length);

              AttributeSet attributes = htmlIterator.getAttributes();
              String attributesHREF = (String) attributes.getAttribute(HTML.Attribute.HREF);

              adresses.add(attributesHREF);
              texts.add(htmlDoc.getText(startOffset,length));
              htmlIterator.next();
      }
	 }
   catch(BadLocationException | IOException e){
       System.out.println("Failed to load web page.");
       System.out.println(e);
       return null;
   }

   // Starts storing URL and tags in matrix
    int row=0;
    int col1=0;
    int col2=1;

    for(int j=0; j<50;j++){
        outputMatrix[row][col1]=adresses.get(j);
        outputMatrix[row][col2]=texts.get(j);
        row++;
    }
    return outputMatrix;
}

public static void main(String[] args){
    WebLinks webLinks = new WebLinks();
  }
}
