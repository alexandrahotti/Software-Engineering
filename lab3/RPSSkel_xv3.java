//Alexandra Hotti & Helena Rosenzweig
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.net.URL;
import sun.audio.*;

public class RPSSkel_xv3 extends JFrame implements ActionListener{
    Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    static Socket socket;
    static BufferedReader in;
    static PrintWriter ut;
    JButton closebutton;
    String computerdraw;
    int gameRunning;
    boolean audio;
    String audioStatus;
    JButton audioButton;

    RPSSkel_xv3 () {
        audio = true;
        audioStatus = "ON";
      	setDefaultCloseOperation(EXIT_ON_CLOSE);
        audioButton = new JButton("Audio: " + audioStatus);
        audioButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if (audio){
              audio = false;
              audioStatus = "OFF";
            }
            else{
              audio = true; där minst tio saker i
              audioStatus = "ON";
            }
            audioButton.setText("Audio: "+audioStatus);
          }
        });
      	closebutton = new JButton("Close");
        closebutton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){

            ut.println("\u0004");ut.flush();
            System.exit(0);
          }
        });
      	myboard = new Gameboard("Alexandra & Helena", this); // Must be changed
      	computersboard = new Gameboard("Computer");
      	JPanel boards = new JPanel();
      	boards.setLayout(new GridLayout(1,2));
      	boards.add(myboard);
      	boards.add(computersboard);
      	add(boards, BorderLayout.CENTER);
        add(audioButton, BorderLayout.NORTH);
      	add(closebutton, BorderLayout.SOUTH);
      	setSize(300, 550);
        String soundName = "yourSound.wav";
      	setVisible(true);
      }
        private static void makesound(String status){
          AudioPlayer MGP = AudioPlayer.player;
          AudioStream BGM;
          AudioData MD;
          ContinuousAudioDataStream loop =null;
        if(status.equals("win")){
        try{
            BGM = new AudioStream(new FileInputStream("applause2_x.wav"));
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);
            //MGP.start(MD);
        } catch (Exception ex) {
              System.out.println(ex);
        }
      }else if (status.equals("lose")){

        try{
            BGM = new AudioStream(new FileInputStream("boo.wav"));
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);
            //MGP.start(MD);
        } catch (Exception ex) {
              System.out.println(ex);
        }
      }else{
        try{
            BGM = new AudioStream(new FileInputStream("drum_roll_y.wav"));
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);
            //MGP.start(MD);

        } catch (Exception ex) {
              System.out.println(ex);
        }
      }
    }
    void draw(ActionEvent event){
            if(counter==0){
              myboard.setLower("ETT");
              computersboard.setLower("ETT");
            }
            if(counter==1){
              myboard.setLower("TVÅ");
              computersboard.setLower("TVÅ");
            }
            if (counter==0 && gameRunning==1){
                myboard.resetColor();
                computersboard.resetColor();
            }
            counter++;
        }
          void checkgameoutcome(ActionEvent event){
            String playerdraw = event.getActionCommand();
            //System.out.println("Computerdraw är "+computerdraw);
            if (playerdraw.equals(computerdraw)){
              myboard.setLower("draw");
              computersboard.setLower("draw");
              if(audio){
                makesound("draw");
              }
            }
            else{
                    if (playerdraw.equals("STEN")){
                            if(computerdraw.equals("PASE")){
                              computersboard.wins();
                              computersboard.setLower("win");
                              myboard.setLower("lose");
                              if(audio){
                                  makesound("lose");
                              }
                            }
                            else{  //om computersdraw.equals("SAX")
                              myboard.wins();
                              computersboard.setLower("lose");
                              myboard.setLower("win");
                              if(audio){
                                  makesound("win");
                              }
                            }
                          }
                    else if(playerdraw.equals("SAX")){
                            if(computerdraw.equals("PASE")){
                              myboard.wins();
                              myboard.setLower("win");
                              computersboard.setLower("lose");
                              if(audio){
                                  makesound("win");
                              }
                            }
                            else{  //om computersdraw.equals("STEN")
                              computersboard.wins();
                              myboard.setLower("lose");
                              computersboard.setLower("win");
                              if(audio){
                                  makesound("lose");
                              }
                            }
                          }
                    else{  //spelarens drag är påse
                          if(computerdraw.equals("STEN")){
                            myboard.wins();
                            myboard.setLower("win");
                            computersboard.setLower("lose");
                            if(audio){
                                makesound("win");
                            }
                          }
                          else{  //om computersdraw.equals("SAX")
                            computersboard.wins();
                            myboard.setLower("lose");
                            computersboard.setLower("win");
                            if(audio){
                              makesound("lose");
                            }
                          }
                        }
                      }
                    }
          public void actionPerformed (ActionEvent event){
            //AudioPlayer.player.stop()
            draw(event);
            if (counter ==3){
                ut.println(event.getActionCommand());
                ut.flush();
                computerdraw =checkcomputerDraw();
                myboard.markPlayed(event.getActionCommand());
                computersboard.markPlayed(computerdraw);
                myboard.setUpper(event.getActionCommand());
                computersboard.setUpper(computerdraw);

                checkgameoutcome(event);
                counter = 0;
            }
            gameRunning=1;
          }
          String checkcomputerDraw(){
            try{
              computerdraw=in.readLine();
           }
             catch(IOException e){
                System.err.println("Couldn't get connection to the server on port 4713");
                System.exit(-1);
           }
           return computerdraw;
          }
          public static void main (String[] u) {
             new RPSSkel_xv3();
             try {
                   socket=new Socket("share-02.csc.kth.se",4713);   //ip adressen till datorn fås med hjälp av ifconfig
                   in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                   ut = new PrintWriter(socket.getOutputStream());
                   ut.println("Alexandra & Helena"); ut.flush(); //gör flush på output pga av gamalt skräp som ligger kvar från tidigare uppkopplingar
                   System.out.println(in.readLine());
                   //ut.println("Alexandra & Helena");
                   //ut.flush();
                   //System.out.println("Hallå");
                  }
             catch(UnknownHostException e){
                   System.err.println("The host is unknown");
                   System.exit(-1);
             }
             catch(IOException e){
                   System.err.println("Couldn't get connection to the server on port 4713");
                   System.exit(-1);
             }
              }
}
