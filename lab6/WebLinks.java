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
String [] adresses;
String [] texts;
int i=0;

public String [][] loadWebPage() throws IOException{

   try{
       in = new URL(webPage).openConnection().getInputStream();
       reader = new InputStreamReader(in);
       htmlKit = new HTMLEditorKit();
       htmlDoc = new HTMLDocument();
       outputMatrix = new String [50][2];
       adresses = new String [50];
       texts = new String [50];

       htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
  //     htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();

       System.out.println((char)reader.read());
       // Lägger in inputStream i ett html dokument
       htmlKit.read(reader, htmlDoc, 0); //BadLocationException kopplat till read
  //     System.out.println(htmlDoc);

       for(HTMLDocument.Iterator htmlIterator = htmlDoc.getIterator(HTML.Tag.A); htmlIterator.isValid(); htmlIterator.next()){
              AttributeSet attributes = htmlIterator.getAttributes();
              String attributesHREF = (String) attributes.getAttribute(HTML.Attribute.HREF);
              int startOffset = htmlIterator.getStartOffset();
			        int endOffset = htmlIterator.getEndOffset();
			        int length = endOffset - startOffset;
		          String text = htmlDoc.getText(startOffset, endOffset);
			        //System.out.println(" - " + text);
              if(!(i==50)){
                  System.out.println("heeeeeeeeeeeej");
                  adresses[i] = attributesHREF;
                  texts[i] = text;
                  for(int m = 0; m<adresses.length; m++){
                    System.out.println("i adresses har vi: ");
                    System.out.println(adresses[i]);
                  }
              }
              i++;
        }
	 }
   catch(BadLocationException | IOException e){
       System.out.println("Failed to load web page.");
   }

int length=adresses.length;
int row=0;
int col1=0;
int col2=1;
for(int j=0; j<length;j++){
  outputMatrix[row][col1]=adresses[j];
  outputMatrix[row][col2]=texts[j];
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
