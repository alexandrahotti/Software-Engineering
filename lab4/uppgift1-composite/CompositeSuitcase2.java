import java.util.ArrayList;
import java.util.List;


public class CompositeSuitcase2 extends Component{
//CompositeSuitcase skapar componentobjekt
static ArrayList<Component> components;
//StringBuilder output;
int totalweight;
StringBuilder family;
static ArrayList<Component> besökta;
//public String compType;



CompositeSuitcase2(int weight, String name){
      super(weight, name);
      family=new StringBuilder(this.itemName+"\n");
      compType="CompositeSuitcase";
      //System.out.println(compType);
      components = new ArrayList<Component>();
      besökta= new ArrayList<Component>();
      //besökta.add(dummy)
}

public void addcomp(Component component){
    components.add(component);
    updatetotalweight();
    updatekids(component);
}

public void updatekids(Component kid){
  //hantering av förälder
  if (!besökt(kid)){
    family.append(kid);
    besökta.add(kid);
    //System.out.println("barnet existerade ej"+kid.itemName);
  }
  //hantering av förälders barn
  if (kid.compType.equals("CompositeSuitcase")){
    for (Component grandkid: this.components){
      family.append(grandkid.itemName+"\n");
    //  besökta.add(grandkid);
      //System.out.println("barnbarnet existerade ej"+grandkid.itemName);
    }
  }
}

public boolean besökt(Component kid){
  int i = -1;
  //System.out.println("kid.itemName: " + kid.itemName);
  for(Component comp: besökta){
    i++;
      //System.out.println("in i for loopen");
      if(besökta.get(i).equals(kid)){
        return true;
      }
      else{
        return false;
      }

  }
  return false;
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

// public String testString(){
//     String output = "";
//     Component comp = this.components.get(0);
//     System.out.println(comp);
//     output += " " + comp;
//     return output;
//    }

public String toString(){
    return family.toString();
}

public void remove(int i){
  components.remove(i);
  updatetotalweight();
}

public Component getChild(int i){
  return components.get(i);
}


}
