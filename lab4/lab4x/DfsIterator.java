import java.util.Stack;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DfsIterator  implements Iterator<Component>{

    Stack<Component> stack = new Stack<>();
    ArrayList<Component> components;

    public DfsIterator(ArrayList components){

        this.components = components;
        CompositeSuitcase root =  (CompositeSuitcase)components.get(0);
        stack.push(root);
        //Iterator<Component> iterator = new Iterator<Component>();
        //stack.push(iterator);
    }

    public boolean hasNext(){

      if (!stack.empty() && stack.peek()!=null){
          return true;
      }
      else{
          return false;
      }
    }

    // Get and return next component item
    public Component next(){


        Component compParent = stack.pop();
        //System.out.println(compParent.itemName+"här");
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
