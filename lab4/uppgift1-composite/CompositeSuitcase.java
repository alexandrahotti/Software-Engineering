import java.util.ArrayList;
import java.util.List;


public class CompositeSuitcase extends Component{
//CompositeSuitcase skapar componentobjekt
ArrayList<Component> components;
//StringBuilder output;
int totalweight;


CompositeSuitcase(int weight, String name){
      super(weight, name);
      components = new ArrayList<Component>();
}

public void add(Component component){
    components.add(component);
    updatetotalweight();
}

public void updatetotalweight(){
    totalweight=0;
    for (Component comp: components){
        totalweight+=comp.getWeight();
    }
    totalweight+=this.itemWeight;
}

public int getWeight(){
  //System.out.println(this.getChild(0));
  return this.itemWeight;
}

public String testString(){
    String output = "";
    Component comp = this.components.get(0);
    System.out.println(comp);
    output += " " + comp;
    return output;
   }
// så om man ber om väskans första next skaman inte få väskan
public String toString(){
  System.out.println("toString: "+this.itemName);
    String output = this.itemName;
  //  output = new StringBuilder(this.itemName+"\n");
//    System.out.println(this.components.itemName);
    for(int i=0; i<this.components.size(); i++){
  //      output.append(this.getChild(i));
        Component comp = this.components.get(i);
        System.out.println("forLoop varv: "+i+" "+comp.itemName);
        output += " " + comp;
    }
    return output;
}

public void remove(int i){
  components.remove(i);
  updatetotalweight();
}

public Component getChild(int i){
  return components.get(i);
}

public static void main(String args[]){
  int i=0;
  System.out.println(++i);
    CompositeSuitcase vaska = new CompositeSuitcase(5,"douchebag");
System.out.println(++i);
    CompositeSuitcase necessar = new CompositeSuitcase(2,"necessar");
    System.out.println(++i);
    Component tandborste = new Leaf(1,"tandborste");
    Component deo = new Leaf(1,"deo");
    Component puder = new Leaf(1,"puder");
System.out.println(++i);
    necessar.add(tandborste);
    System.out.println(++i);
    necessar.add(deo);
System.out.println(++i);
    necessar.add(puder);

    vaska.add(necessar);

    Component troja = new Leaf(2,"troja");
    Component byxa = new Leaf(2,"byxor");

    vaska.add(troja);
    vaska.add(byxa);
System.out.println(++i);
    necessar.getWeight();
    System.out.println(++i);
  //  System.out.println(necessar.toString());
    System.out.println(necessar);
    System.out.println(vaska);
}

}
