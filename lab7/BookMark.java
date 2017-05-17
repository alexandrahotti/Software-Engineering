
import java.io.Serializable;

public class BookMark  implements Serializable {

    String name;
    String url;

    BookMark(String name, String url){
        this.name = name;
        this.url = url;
    }

    public String toString(){
        return this.name;
    }
    public String getUrl(){
        return this.url;
    }

}
