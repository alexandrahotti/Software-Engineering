/*******************************************
OBS! No swedish letters in this program.
STEN, SAX and PASE is played.
STEN = ROCK, SAX = SCISSORS, PASE = PAPER
*******************************************/
import java.net.*;
import java.io.*;
import java.util.*;
public class Server47{ //13 
    public static void main( String[] args) {
	try {
	    ServerSocket sock = new ServerSocket(4711,100); //första numret ska vara samma portnummer som specificerat i klienten
	    while (true)
		new ClientHandler(sock.accept()).start();  //accept accepterar inkommande requesten till sock
	}  //start används eftersom att clienthandler är en thread
	catch(IOException e)
	    {System.err.println(e);
	}
    }
}

class ClientHandler extends Thread {
    static int antaltr=0;
    BufferedReader in;
    PrintWriter ut;
    public ClientHandler(Socket socket){
	try {
	    in = new BufferedReader(new InputStreamReader
				    (socket.getInputStream()));   //accept the input that the cleints wants to pass
	    ut= new PrintWriter(socket.getOutputStream()); //to pass the result to the client
	}
	catch(IOException e) {System.err.println(e);
	}
    }

    public void run() {  //detta ligger i ClientHandler
        	Random random=new Random();
        	String[] hand={"STEN","SAX","PASE"};
        	try {
        	    String namn=in.readLine();
        	    System.out.println((++antaltr)+": "+namn);
                    ut.println("Hej, "+namn);
                    ut.flush();
        	    while(true) {
                		String indata = in.readLine();
                		if(indata==null || indata.equals("")) break;
                		ut.println(hand[random.nextInt(3)]);
                		ut.flush();
        	    }
        	    System.out.println("Nu slutade "+namn);
        	    antaltr--;
        	}
                catch(Exception e) {
        	    System.err.println(e);
        	}
        }
}
