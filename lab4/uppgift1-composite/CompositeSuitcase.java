import java.util.ArrayList;
import java.util.List;


public class CompositeSuitcase extends Component{
//CompositeSuitcase skapar componentobjekt
static ArrayList<Component> components;
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
  System.out.println(this.getChild(0));
  return this.itemWeight;
}

public String testString(){
    String output = "";
    Component comp = this.components.get(0);
    System.out.println(comp);
    output += " " + comp;
    return output;
   }

public String toString(){
    String output = "";
  //  output = new StringBuilder(this.itemName+"\n");
//    System.out.println(this.components.itemName);
    for(int i=0; i<this.components.size(); i++){
  //      output.append(this.getChild(i));
        Component comp = this.components.get(i);
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
    CompositeSuitcase väska = new CompositeSuitcase(5,"douchebag");

    CompositeSuitcase necessär = new CompositeSuitcase(2,"necessär");
    Component tandborste = new Leaf(1,"tandborste");
    Component deo = new Leaf(1,"deo");
    Component puder = new Leaf(1,"puder");

    necessär.add(tandborste);
    necessär.add(deo);
    necessär.add(puder);

    väska.add(necessär);

    Component tröja = new Leaf(2,"tröja");
    Component byxa = new Leaf(2,"byxor");

    väska.add(tröja);
    väska.add(byxa);

    necessär.getWeight();
  //  System.out.println(necessär.toString());
    System.out.println(necessär);
}

}
