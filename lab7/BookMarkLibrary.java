import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

public class BookMarkLibrary{

    static Scanner sc;
    FileInputStream inputStream
	  ObjectInputStream objectInputStream
    ArrayList<BookMark> bookMarks;

    BookMarkLibrary(){
        bookMarks = new ArrayList();
        sc = new Scanner();

    }

    public void addBookMark(String name, String url){
        BookMark bookMark = new BookMark(name, url);
        bookMarks.add(bookMark);
        // Write objects to file
    }

    public String removeBookMark(String name){
        for(int i = 0; i < bookMark.size(); i++){
            if(bookMarks.get(i).equals(name)){
                bookMarks.remove(i);
                return "Removed book mark.";
            }
            else{
                return "Book mark does not exist.";
            }
        }
    }

    public void initBookMarkLibrary(){
        try {
        			inputStream = new FileInputStream(new File("bookMarks.txt"));
        			objectInputStream = new ObjectInputStream(inputStream);

        			// Read objects
            while(true){
        			     BookMark bookMark = (BookMark) objectInputStream.readObject();
                   addBookMark(bookMark.name, bookMark.url);
            }
        		}
            catch (FileNotFoundException e) {
        			     System.out.println("File not found");
        		} catch (IOException e) {
        			     System.out.println("Error initializing stream");
        		}
    }

    public void updateBookMarks(){

        try{
            new FileOutputStream("bookMarks.txt").close();
            outputStream = new FileOutputStream(new File("bookMarks.txt"));
            objectOutputStream = new ObjectOutputStream(outputStream);
        }

        for(BookMark bookMark: bookMarks){
            objectOutputStream.writeObject(bookMark);
        }
    }


    public void sortBookMarks(){
      Collections.sort(bookMarks, new Comparator<BookMark>() {
      public int compare(BookMark bookMark1, BookMark bookMark2){
          return  bookMark1.name.compareTo(bookMark2.name);
      }
  });
    }
}
