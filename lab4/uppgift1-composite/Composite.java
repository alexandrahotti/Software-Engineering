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
Composite(int weight, String name){
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
    return totalweight;
}

// Returns a string of the name of the container and
// all of its items
public String toString(){
    String output = this.itemName;
    for(int i=0; i<this.components.size(); i++){
        Component comp = this.components.get(i);
        output += " " + comp;ssa
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
    Composite vaska = new Composite(5,"douchebag");
    Composite necessar = new Composite(2,"necessar");
    Composite planbok = new Composite(1, "planbok");

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

  //  System.out.println(necessar);
    System.out.println(vaska);
    System.out.println("necessären och dess innehåll väger " +necessar.getWeight()+" kg");
    System.out.println("plånboken och dess innehåll väger "+planbok.getWeight()+" kg");
    System.out.println("pudret väger "+puder.getWeight()+" kg");
  }
}
