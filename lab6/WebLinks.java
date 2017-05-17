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

public String [][] loadWebPage(String webPage) throws IOException{
    try{
       in = new URL(webPage).openConnection().getInputStream();
       reader = new InputStreamReader(in, "UTF-8");

       htmlDoc = new HTMLDocument();
       htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

       htmlKit = new HTMLEditorKit();
       htmlKit.read(reader, htmlDoc, 0);

       outputMatrix = new String [50][2];
       //adresses = new String [50];
       //texts = new String [50];

       adresses = new ArrayList<>();
       texts = new ArrayList<>();
       HTMLDocument.Iterator htmlIterator = htmlDoc.getIterator(HTML.Tag.A);
       while(htmlIterator.isValid()){
            //htmlKit.read(reader, htmlDoc,0);
              int startOffset = htmlIterator.getStartOffset();
			        int endOffset = htmlIterator.getEndOffset();
			        int length = endOffset - startOffset;

              String text = htmlDoc.getText(startOffset, endOffset);

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
   }
// System.out.println();
// System.out.println("MATRISEN");
// for (int h=0; h<2;h++){
//   for(int g=0; g<adresses.length;g++){
//       System.out.println(outputMatrix[g][h]);
//   }
// }
    System.out.println("Trätt ut ur for iteratorloopen");
  //  int length=adresses.size();
    int row=0;
    int col1=0;
    int col2=1;

    System.out.println(adresses.size());

    for(int j=0; j<adresses.size();j++){
        outputMatrix[row][col1]=adresses.get(j);
        outputMatrix[row][col2]=texts.get(j);
        row++;
    }
    System.out.println("Når vi till matrisen?");
    return outputMatrix;
}

public static void main(String[] args){
    WebLinks webLinks = new WebLinks();
//    try{
//        webLinks.loadWebPage(webPage);
//    }
//    catch(IOException e){
//        System.out.println("Failed to load web page.");
//  }
  }
}
//http://www.programcreek.com/java-api-examples/index.php?class=javax.swing.text.html.HTMLDocument&method=Iterator
