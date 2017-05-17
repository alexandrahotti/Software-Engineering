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

    //   System.out.println((char)reader.read());
       // Lägger in inputStream i ett html dokument
       System.out.println("SKA LÄSA AV HTML OCH LÄGGA I HTMLDOC");
       htmlKit.read(reader, htmlDoc, 0); //BadLocationException kopplat till read
       System.out.println("HAR LÄST AV HTML OCH LÄGGA I HTMLDOC");
  //     System.out.println(htmlDoc);

       for(HTMLDocument.Iterator htmlIterator = htmlDoc.getIterator(HTML.Tag.A); htmlIterator.isValid(); htmlIterator.next()){
              AttributeSet attributes = htmlIterator.getAttributes();
              String attributesHREF = (String) attributes.getAttribute(HTML.Attribute.HREF);
              int startOffset = htmlIterator.getStartOffset();
			        int endOffset = htmlIterator.getEndOffset();
			        int length = endOffset - startOffset;
		          String text = htmlDoc.getText(startOffset, endOffset);
			        //System.out.println(" - " + text);

              System.out.println("i är: " +i);

              if(i!=50){
                  System.out.println("heeeeeeeeeeeej");
                  adresses[i] = attributesHREF;
                  texts[i] = text;
                  //for(int m = 0; m<adresses.length; m++){
                  System.out.println("i adresses & text har vi: ");
                  System.out.println(adresses[i]);
                  System.out.println(texts[i]);
                  //}
              }
              i++;
              System.out.println("Efter loopen är i: "+i);
        }
        System.out.println("Trätt ut ur for iteratorloopen");
        int length=adresses.length;
        int row=0;
        int col1=0;
        int col2=1;
        for(int j=0; j<length;j++){
          outputMatrix[row][col1]=adresses[j];
          outputMatrix[row][col2]=texts[j];
          row++;
        }


	 }
   catch(BadLocationException | IOException e){
       System.out.println("Failed to load web page.");
   }
// System.out.println();
// System.out.println("MATRISEN");
// for (int h=0; h<2;h++){
//   for(int g=0; g<adresses.length;g++){
//       System.out.println(outputMatrix[g][h]);
//   }
// }
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
//http://www.programcreek.com/java-api-examples/index.php?class=javax.swing.text.html.HTMLDocument&method=Iterator
