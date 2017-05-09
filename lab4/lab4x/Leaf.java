
public class Leaf extends Component{

Leaf(int weight, String item){
      super(weight, item);  //super ger Leaf
      this.iterable = false;
      compType="Leaf";
    //  compType="Leaf";
}

public int getWeight(){
    return this.itemWeight;
}

public String toString(){
      return this.itemName;

    }
}
