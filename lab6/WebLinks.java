


class WebLinks{

WebLinks{

String webpage="http://www.nada.kth.se/~henrik";
   InputStream in=new URL(webpage).openConnection().getInputStream();
   InputStreamReader reader= new InputStreamReader(in);
   while(reader.ready())
      System.out.print((char)reader.read());

      doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
   new HTMLEditorKit().read(reader,doc,0);

public static void main(String[] args){
  
}
}
}
