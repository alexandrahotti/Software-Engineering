//
//   Authors:
//   Alexandra Hotti & Helena Rosenzweig
//

import java.util.ArrayList;
import java.util.List;

// Composite class for container objects
public class Composite extends Component{

ArrayList<Component> components;
int totalweight;

// Creates object according to Component constructor
// conponents ArrayList keeps track of what is in the current container
CompositeSuitcase(int weight, String name){
      super(weight, name);
      components = new ArrayList<Component>();
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
    System.out.println("toString: "+this.itemName);
    String output = this.itemName;
    for(int i=0; i<this.components.size(); i++){
        Component comp = this.components.get(i);
        System.out.println("forLoop varv: "+i+" "+comp.itemName);
        output += " " + comp;
    }
    return output;
}
// Removes container object, updates total weight
public void remove(int i){
  components.remove(i);
  updatetotalweight();
}

// Returns a component for a given index
public Component getChild(int i){
  return components.get(i);
}

// Main method where we create and add several
// containers and items.
public static void main(String args[]){
    int i=0;
    System.out.println(++i);
    Composite vaska = new Composite(5,"douchebag");
    System.out.println(++i);
    Composite necessar = new Composite(2,"necessar");
    System.out.println(++i);
    Leaf tandborste = new Leaf(1,"tandborste");
    Leaf deo = new Leaf(1,"deo");
    Leaf puder = new Leaf(1,"puder");
    System.out.println(++i);
    necessar.add(tandborste);
    System.out.println(++i);
    necessar.add(deo);
    System.out.println(++i);
    necessar.add(puder);

    vaska.add(necessar);

    Leaf troja = new Leaf(2,"troja");
    Leaf byxa = new Leaf(2,"byxor");

    vaska.add(troja);
    vaska.add(byxa);
    System.out.println(++i);
    necessar.getWeight();
    System.out.println(++i);

    System.out.println(necessar);
    System.out.println(vaska);
  }
}
