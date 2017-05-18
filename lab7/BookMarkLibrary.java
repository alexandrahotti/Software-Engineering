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

// Start Serializable solution

public class BookMarkLibrary implements Serializable{

  //  FileInputStream inputStream;
	//  ObjectInputStream objectInputStream;
    ArrayList<BookMark> bookMarks;

    BookMarkLibrary(){
        bookMarks = new ArrayList();
    //    try{
    //    deserializeBookMark();
    //    }
    //    catch{

    //    }
    }

    public void addBookMark(String name, String url){
        BookMark bookMark = new BookMark(name, url);
        bookMarks.add(bookMark);
        serializeBookMark();

        // Write objects to file
    }

    public String removeBookMark(String namer){
        for(int i = 0; i < bookMarks.size(); i++){
            // System.out.println("bookremove innan");
            // System.out.println(bookMarks.get(i)+".get(i)");
            // System.out.println(name+"name");

            if(bookMarks.get(i).name.equals(namer)){

                System.out.println("bookremove efter");
                System.out.println(bookMarks.remove(i));
                serializeBookMark();
                return "Removed book mark.";
            }
        }
        return "Book mark does not exist.";
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

    // public void deserializeBookMark() throws *** EXCEPTION***{
    //     try {
    //           List<Object> objectBookMarks = null;
    //           FileInputStream inputStream = new FileInputStream("/tmp/bookMarks.ser");
    //           ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    //           objectBookMarks = objectInputStream.readObject();
    //
    //       //    (List<BookMark>)(Object)objectBookMarks;
    //   //        for(BookMark bookMark: objectBookMarks){
    //     //          bookMarks.add(bookMark);
    //       //    }
    //           objectInputStream.close();
    //           inputStream.close();
    //      }
    //      catch(IOException error1) {
    //           error1.printStackTrace();
    //           return;
    //      }
    //      catch(ClassNotFoundException error2) {
    //           System.out.println("Employee class not found");
    //           error2.printStackTrace();
    //           return;
    //     }
    // }

    public void sortBookMarks(){
      Collections.sort(bookMarks);
    }
}
