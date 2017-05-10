
public class BfsIterator<Component> implements Iterator{
    private Queue<Component> linkedlist = new LinkedList<>();
    ArrayList<Component> components;

    BfsIterator(ArrayList<Component>  components){
      this.components = components;
      CompositeSuitcase root =  (CompositeSuitcase)components.get(0);
      linkedlist.add(root);
      root.visited=True;
    }
    boolean hasNext(){
      return linkedlist.peek()!=null;
    }

    Component next(){}
      if(hasNext()){
        Component comp = linkedlist.remove();
      }

    void remove(){}


}
