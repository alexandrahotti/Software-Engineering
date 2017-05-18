//
//    Authors:
//    Helena Rosenzweig & Alexandra Hotti
//    DD2385: Lab assignment 7
//

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;


// Handles and stores all BookMark objects.
public class BookMarkLibrary implements Serializable{

    ArrayList<BookMark> bookMarks;

//  Initialises bookMark Library:
    BookMarkLibrary(){
        bookMarks = new ArrayList();
        try{
            deserializeBookMark();
        }
        catch(IOException e){
            return;
        }
    }

//  Adds a new bookMark to the library, and saves it in
//  ser-file (file for storing objects):
    public void addBookMark(String name, String url){
        BookMark bookMark = new BookMark(name, url);
        bookMarks.add(bookMark);
        serializeBookMark();
    }

//  Removes a bookMark from the library, and update
//  the ser-file (file for storing objects):
    public String removeBookMark(String namer){
        for(int i = 0; i < bookMarks.size(); i++){
            try{
            if(bookMarks.get(i).name.equals(namer)){

                System.out.println("bookremove efter");
                System.out.println(bookMarks.remove(i));
                serializeBookMark();
                return "Removed book mark.";
            }
          }
          catch(NullPointerException e){
               return null;
          }
        }
      return "Book mark does not exist.";
    }

//  Updates ser-file by erasing all of its content,
//  and writing all object BookMarks currently stored in library:
    public void serializeBookMark(){
        try {
             new FileOutputStream("/afs/kth.se/home/h/e/helros/school/prutten_labs/lab7/bookMarks.ser").close();
             FileOutputStream outputStream = new FileOutputStream("/afs/kth.se/home/h/e/helros/school/prutten_labs/lab7/bookMarks.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
             objectOutputStream.writeObject(bookMarks);

             objectOutputStream.close();
             outputStream.close();
      }
      catch(IOException error) {
             error.printStackTrace();
      }
    }

//  Updates our bookMark library by reading content from ser-file,
//  creating objects from this and adding these to library:
    public void deserializeBookMark() throws IOException{
        try {
              FileInputStream inputStream = new FileInputStream("/afs/kth.se/home/h/e/helros/school/prutten_labs/lab7/bookMarks.ser");
              ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
              List<BookMark> objectBookMarks = (List<BookMark>)objectInputStream.readObject();
              for(BookMark bookMark: objectBookMarks){
                  bookMarks.add(bookMark);
              }
              objectInputStream.close();
              inputStream.close();
         }
         catch(IOException | ArrayIndexOutOfBoundsException error1) {
              return;
         }
         catch(ClassNotFoundException error2) {
              return;
        }
    }

//  Sorts bookMarks in library alphabetically with respect to
//  the name of the bookMark:
    public void sortBookMarks(){
      Collections.sort(bookMarks);
    }
}
