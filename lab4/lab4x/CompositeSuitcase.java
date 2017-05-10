//
//   Authors:
//   Alexandra Hotti & Helena Rosenzweig
//

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// Composite class for container objects
public class CompositeSuitcase extends Component implements Iterable<Component>{

ArrayList<Component> components;
int totalweight;

// Creates object according to Component constructor
// conponents ArrayList keeps track of what is in the current container
CompositeSuitcase(int weight, String name){
      super(weight, name);
      components = new ArrayList<Component>();
      this.iterable = true;
      this.visited=false;

}

// Adds new items to the container
public void add(Component component){
    components.add(component);
    updatetotalweight();
}

// Updates the total weight of the container
// i.e. sums the weight of the container and its items
public void updatetotalweight(){
    totalweight=0;
    for (Component comp: components){
        totalweight+=comp.getWeight();
    }
    totalweight+=this.itemWeight;
}

// Returns the total weight of the container
public int getWeight(){
    return this.itemWeight;
}

// Returns a string of the name of the container and
// all of its items
public String toString(){
    //System.out.println("toString: "+this.itemName);
    String output = this.itemName;
    for(int i=0; i<this.components.size(); i++){
        Component comp = this.components.get(i);
        //System.out.println("forLoop varv: "+i+" "+comp.itemName);
        output += " " + comp;
    }
    return output;
}
// Removes container object, updates total weight
public void remove(Component comp){
  int index = components.indexOf(comp);
  components.remove(index);
  updatetotalweight();
}

// Returns a component for a given index
public Component getChild(int i){
  return components.get(i);
}

//if (comp instanceof Composite) {

public Iterator<Component> iterator(){
      return new DfsIterator(components);
}


// Main method where we create and add several
// containers and items.
public static void main(String args[]){

    //System.out.println(++i);
    CompositeSuitcase vaska = new CompositeSuitcase(5,"douchebag");
    //System.out.println(++i);
    CompositeSuitcase necessar = new CompositeSuitcase(2,"necessar");
    //System.out.println(++i);
    Leaf tandborste = new Leaf(1,"tandborste");
    Leaf deo = new Leaf(1,"deo");
    Leaf puder = new Leaf(1,"puder");
    //System.out.println(++i);
    necessar.add(tandborste);
    //System.out.println(++i);
    necessar.add(deo);
    //System.out.println(++i);
    necessar.add(puder);

    vaska.add(necessar);

    Leaf troja = new Leaf(2,"troja");
    Leaf byxa = new Leaf(2,"byxor");

    vaska.add(troja);
    vaska.add(byxa);

    necessar.getWeight();


//  DFS ITERATOR:

    Iterator<Component> iteratorn = vaska.iterator();

    int j = 0;


    // if (iteratorn instanceof Iterator) {
    //   System.out.println("vanlig iterator!");
    // }
    // if(iteratorn instanceof DfsIterator){
    //   System.out.println("dfs iterator!");
    // }



    while(iteratorn.hasNext()){
      //System.out.println(iteratorn.next()+" next");

      //Component comp = iteratorn.next();
      System.out.println(iteratorn.next());
      j++;
    }


    // while(hasNext()){
    //     Iterator<Component> Iterator = stack.peek();
    //     Component component = iterator.peek();
    //     stack.push(component.createIterator());
    //     return component;
    //
    // }


    //här används .iterator på objekten som ska itereras över
  }
}
