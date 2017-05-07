public class HumanFactory extends Human{



public static void main(String[]args){
  Human alex = Human.create("Alex","950128-9801");
  new Human(){
  };
  System.out.println(alex);
//  TESTFALL SOM INTE FUNGERAR:
//  Human human = new Human("950128-9801");
}

}
