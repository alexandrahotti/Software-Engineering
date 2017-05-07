//Alexandra Hotti & Helena Rosenzweig

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.*;
import java.net.*;

public class TestServer{

    TestServer(){
    }

public static void main(String[] args){
   try {
       Socket socket=new Socket("share-02.csc.kth.se",4713);   //ip adressen till datorn fås med hjälp av ifconfig
       BufferedReader in=new BufferedReader
           (new InputStreamReader(socket.getInputStream()));
       PrintWriter ut=new PrintWriter(socket.getOutputStream());
       ut.println("Charlotta"); ut.flush(); //gör flush på output pga av gamalt skräp som ligger kvar från tidigare uppkopplingar
       System.out.println(in.readLine());
       System.out.println("hej");

       ut.println("SAX");ut.flush();
       System.out.println(in.readLine());

       ut.println("SAX");ut.flush();
       System.out.println(in.readLine());
       ut.println("SAX");ut.flush();
       System.out.println(in.readLine());

   }catch(UnknownHostException e){
     System.err.println("The host is unknown");
     System.exit(-1);
   }
   catch(IOException e){
     System.err.println("Couldn't get connection to the server on port 4713");
     System.exit(-1);

   }
 }
}
