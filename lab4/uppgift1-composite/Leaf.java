//Helena Rosenzweig & Alexandra Hotti
public class Leaf extends Component{



Leaf(int weight, String item){
      super(weight, item);  //super ger Leaf
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
