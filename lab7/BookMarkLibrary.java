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

// Start Serializable solution

public class BookMarkLibrary implements Serializable{

  //  FileInputStream inputStream;
	//  ObjectInputStream objectInputStream;
    ArrayList<BookMark> bookMarks;

    BookMarkLibrary(){
        bookMarks = new ArrayList();
        deserializeBookMark();
    }

    public void addBookMark(String name, String url){
        BookMark bookMark = new BookMark(name, url);
        bookMarks.add(bookMark);
        serializeBookMark();

        // Write objects to file
    }

    public String removeBookMark(String name){
        for(int i = 0; i < bookMarks.size(); i++){
            if(bookMarks.get(i).equals(name)){
                bookMarks.remove(i);
                return "Removed book mark.";
            }
            else{
                return "Book mark does not exist.";
            }
        }
    }

    public void serializeBookMark(){
        try {
             new FileOutputStream("/tmp/bookMarks.ser").close();
             FileOutputStream outputStream = new FileOutputStream("/tmp/bookMarks.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
             objectOutputStream.writeObject(bookMarks);

            // for(BookMark bookMark: bookMarks){
            //     objectOutputStream.writeObject(bookMark);
            // }

             objectOutputStream.close();
             outputStream.close();
      }
      catch(IOException error) {
             error.printStackTrace();
      }
    }

    public void deserializeBookMark(){
        try {
            //  List<BookMark> objectBookMarks = null;
              FileInputStream inputStream = new FileInputStream("/tmp/bookMarks.ser");
              ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
              objectBookMarks = objectInputStream.readObject();
              for(Object bookMark: objectBookMarks){
                  bookMark = (BookMark) bookMark;
                  objectBookMarks.add(bookMark);
              }
              objectInputStream.close();
              inputStream.close();
         }
         catch(IOException error1) {
              error1.printStackTrace();
              return;
         }
         catch(ClassNotFoundException error2) {
              System.out.println("Employee class not found");
              error2.printStackTrace();
              return;
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
