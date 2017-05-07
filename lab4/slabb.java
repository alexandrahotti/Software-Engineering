import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CompositeSuitcase extends Component{ // allows the object CompositeSuitcase to be the target of the "foreach" statement
//CompositeSuitcase skapar componentobjekt
static List<Component> väskinnehåll;
int weight;
int totalweight;
String pryltyp;
int viktcomp;
//vi ska här skapa en lista av Components
    CompositeSuitcase(int weight, String pryltyp){
      super();
      this.weight=weight;
      this.pryltyp=pryltyp;
      väskinnehåll = new ArrayList<Component>();
      }

public void add(Component objekt){
    väskinnehåll.add(objekt);
    updatetotalweight();
}

public void updatetotalweight(){
  totalweight=0;
  for (Component comp: väskinnehåll){
    comp.getWeight();
    //totalweight=totalweight+viktcomp;
  }
  //totalweight=totalweight+this.weight;
}

public void getWeight(){
  for(int i=0;i<väskinnehåll.size();i++){
    Component barn=getChild(i);
    System.out.println(barn.;
  }
  System.out.println(this.weight);
}

public String toString(){
    return pryltyp;
  }

public void remove(int i){
  väskinnehåll.remove(i);
  updatetotalweight();
}

public Component getChild(int i){

  return väskinnehåll.get(i);

}

// PÅBÖRJAD ITERATORMETODER

// public Iterator<Component> iterator(String iterator){
//
//       if (iterator == BfsIterator){
//           iterator = new BfsIterator();
//       }
//       else if(iterator == DfsIterator){
//           iterator = new DfsIterator();
//       }
//       else{
//           System.out.println("Invalid iterator.");
//       }
//       return iterator;
// }


public static void main(String args[]){
    CompositeSuitcase väska = new CompositeSuitcase(5,"douchebag");

    Leaf tandborste = new Leaf(1,"tandborste");
    CompositeSuitcase necessär = new CompositeSuitcase(2,"necessär");
    Leaf hårnål =new Leaf(1, "hårnål");
    CompositeSuitcase burk =new CompositeSuitcase(1,"burk");

    burk.add(hårnål);
    necessär.add(tandborste);
    necessär.add(burk);
    väska.add(necessär);
//    for (Component comp: väska){
      System.out.println(burk);
  //  }
    System.out.println(väska.totalweight);



}

}
