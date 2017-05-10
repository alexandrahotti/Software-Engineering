//
//   Authors:
//   Alexandra Hotti & Helena Rosenzweig
//

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// CompositeSuitcase class for container objects
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
      //return new BfsIterator(this);
      return new DfsIterator(this);
}


// Main method where we create and add several
// containers and items.
public static void main(String args[]){
  CompositeSuitcase vaska = new CompositeSuitcase(5,"vaska");
  CompositeSuitcase necessar = new CompositeSuitcase(2,"necessar");
  CompositeSuitcase planbok = new CompositeSuitcase(1, "planbok");

  Leaf tandborste = new Leaf(1,"tandborste");
  Leaf deo = new Leaf(1,"deo");
  Leaf puder = new Leaf(1,"puder");
  Leaf troja = new Leaf(2,"troja");
  Leaf byxa = new Leaf(2,"byxor");
  Leaf skor = new Leaf(3,"skor");
  Leaf kreditkort = new Leaf(1, "kreditkort");


  necessar.add(tandborste);
  necessar.add(deo);
  necessar.add(puder);
  planbok.add(kreditkort);
  vaska.add(necessar);
  vaska.add(planbok);

  vaska.add(skor);
  vaska.add(troja);
  vaska.add(byxa);



//  DFS ITERATOR:

    Iterator<Component> iteratorn = vaska.iterator();




    // if (iteratorn instanceof Iterator) {
    //   System.out.println("vanlig iterator!");
    // }
    // if(iteratorn instanceof DfsIterator){
    //   System.out.println("dfs iterator!");
    // }



    while(iteratorn.hasNext()){
      //System.out.println(iteratorn.next()+" next");
      //Component comp = iteratorn.next();
      System.out.println(iteratorn.next().itemName);

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
