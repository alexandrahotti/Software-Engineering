
public class Leaf extends Component{
int weight;
String pryltyp;


    Leaf(int weight, String pryltyp){
      super();
      this.weight=weight;
      this.pryltyp=pryltyp;
}

  public int getWeight(){
    return this.weight;

}

  public String toString(){
      return this.pryltyp;

    }
}
