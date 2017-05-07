

import java.util.Stack;
import java.util.*;


public class DfsIterator implements Iterator<Component>{

    Stack<Iterator<Component>> stack = new Stack<Iterator<Component>>();

    public DfsIterator(){
        Iterator<Component> iterator = new Iterator<Component>();
        stack.push(iterator);
    }

    public boolean hasNext(){
        if(stack.empty()){
            return false;
        }
        else{
            Iterator<Component> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            }
            else{
                return true;
            }
        }
    }

    public Component next(){
        if(hasNext()){
            Iterator<Component> Iterator = stack.peek();
            Component component = iterator.peek();
            stack.push(component.createIterator());
            return component;
        }
        else{
            return null;
        }
    }

    public void remove(){
    }
}
