import java.util.Stack;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DfsIterator implements Iterator<Component>{

    Stack<Component> stack = new Stack<Component>();
    ArrayList<Component> components;

    public DfsIterator(ArrayList components){
        this.components = components;
        CompositeSuitcase root =  (CompositeSuitcase)components.get(0);
        stack.push(root);
        //Iterator<Component> iterator = new Iterator<Component>();
        //stack.push(iterator);
    }

    public boolean hasNext(){
      System.out.println("vi kom in i vår egna hasnext");
      if (stack.peek()!=null){
          return true;
      }
      else{
          return false;
      }
    }

    // Get and return next component item
    public Component next(){

        System.out.println("den kmr in i next!!!!!!!!!!!!!!!!!");
        Component compParent = stack.pop();
        System.out.println(compParent.itemName+"här");
        // if(compParent.iterable){
        //   //Composite cmp =stack.pop();
        //   for(Component compKid: compParent.components){
        //     stack.push(compKid);
        //     //vi pushar alla
        //   } }
          return compParent;


    }

    // Implementation unnecessary
    public void remove(){
    }
}
