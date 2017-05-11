//Helena Rosenzweig & Alexandra Hotti
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.*;


public class BfsIterator implements Iterator{
    private Queue<Component> linkedlist = new LinkedList<>();
    ArrayList<Component> components;

    BfsIterator(Component root){
        linkedlist.add(root);
    //    root.visited=True;
    }
    public boolean hasNext(){
      return linkedlist.peek()!=null;
    }

    public Component next(){
      Component compParentTemp = linkedlist.remove();
//      System.out.println("Objektet som poppades från stacken är: "+compParentTemp.itemName);
      if(compParentTemp.iterable){
        CompositeSuitcase compParent = (CompositeSuitcase) compParentTemp;
        //Composite cmp =stack.pop();
        for(Component compKid: compParent.components){
          linkedlist.add(compKid);
          //vi pushar alla
        }
       }
      return compParentTemp;


  }

    public void remove(){}


}
