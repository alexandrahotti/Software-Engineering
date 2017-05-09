
public abstract class Component {

protected String itemName;
protected int itemWeight;
protected String compType;
boolean iterable;

public Component(int weight, String name){
      this.itemName = name;
      this.itemWeight = weight;
      //this.compType=compType;
}

public abstract int getWeight();
public abstract String toString();


}
